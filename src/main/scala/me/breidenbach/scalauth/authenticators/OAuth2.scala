package me.breidenbach.scalauth.authenticators

import me.breidenbach.scalauth.identifier.ScauthIdentifier

/**
 * Date: 1/19/14
 * Time: 7:49 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
abstract class OAuth2 extends Authenticator {
}

object OAuth2Keys {
  val AuthorizationUrl = "authorizationUrl"
  val AccessTokenUrl = "accessTokenUrl"
  val ClientId = "clientId"
  val ClientSecret = "clientSecret"
  val Scope = "scope"
}