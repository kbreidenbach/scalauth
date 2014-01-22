package me.breidenbach.scalauth.authenticators

import me.breidenbach.scalauth.Configurator
import com.google.api.client.auth.oauth.{OAuthAuthorizeTemporaryTokenUrl, OAuthGetTemporaryToken, OAuthHmacSigner}
import com.google.api.client.http.apache.ApacheHttpTransport
import com.google.api.client.http.HttpResponseException

/**
 * Date: 1/19/14
 * Time: 7:48 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */

case class ConsumerKey(consumerKey: String, consumerSecret: String)

case class OAuthInfo(requestTokenUrl: String, accessTokenUrl: String, authorizationUrl: String, callbackUrl: String, keys: ConsumerKey)


abstract class OAuth() extends Authenticator {
  val oauthInfo = buildOAuthInfo
  
  def authenticate() {
    OAuthAuthenticator.authenticate(oauthInfo)
  }

  private def config(key: String): Option[String] = {
    Configurator.get(authenticatorType, key)
  }

  private def buildOAuthInfo: OAuthInfo = {
    val result = for {
      requestTokenUrl: String <- config(OAuthKeys.RequestTokenUrl)
      accessTokenUrl: String <- config(OAuthKeys.AccessTokenUrl)
      authorizationUrl: String <- config(OAuthKeys.AuthorizationUrl)
      callbackUrl: String <- config(OAuthKeys.CallbackUrl)
      consumerKey: String <- config(OAuthKeys.ConsumerKey)
      consumerSecret: String <- config(OAuthKeys.ConsumerSecret)
    } yield {
      OAuthInfo(requestTokenUrl, accessTokenUrl, authorizationUrl, callbackUrl, ConsumerKey(consumerKey, consumerSecret))
    }

    result.isDefined match {
      case true => result.get
      case _ => throw new AuthenticationException("[scauth] missing properties for " + authenticatorType)
    }
  }
}

object OAuthKeys {
  val RequestTokenUrl = "requestTokenUrl"
  val AccessTokenUrl = "accessTokenUrl"
  val AuthorizationUrl = "authorizationUrl"
  val CallbackUrl = "callbackUrl"
  val ConsumerKey = "consumerKey"
  val ConsumerSecret = "consumerSecret"
}

object OAuthAuthenticator {
  val signer = new OAuthHmacSigner

  def authenticate(info: OAuthInfo): Either[String, Error] = {
    val tempToken = new OAuthGetTemporaryToken(info.requestTokenUrl)
    val authorizeUrl = new OAuthAuthorizeTemporaryTokenUrl(info.authorizationUrl)

    try {
      signer.clientSharedSecret = info.keys.consumerSecret
      tempToken.transport = new ApacheHttpTransport()
      tempToken.signer = signer
      tempToken.consumerKey = info.keys.consumerKey
      //tempToken.callback = info.callbackUrl

      val tempCred = tempToken.execute

      signer.tokenSharedSecret = tempCred.tokenSecret
      authorizeUrl.temporaryToken = tempCred.token
      Left(authorizeUrl.build)
    } catch {
      case e:HttpResponseException =>
        Right(new Error(e.getMessage))
    }
  }
}

