package me.breidenbach.scalauth.authenticators

import me.breidenbach.scalauth.authenticators.Authenticators.Authenticators

/**
 * Date: 1/19/14
 * Time: 5:44 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
trait AuthenticatorDetail {
  def authenticator: Authenticators
  def userId: Option[String]
  def password: Option[String]
  def firstName: Option[String]
  def lastName: Option[String]
  def displayName: Option[String]
  def avatarUrl: Option[String]
}

trait LoginInfo {
  def username: Option[String]
  def password: Option[String]
}

// TODO set this up correctly
trait Authenticator {
  def authenticatorType: String
  def authenticate(info: Option[LoginInfo]): Either[AuthenticatorDetail, Error]
  //protected def parseResponse(response: String): Option[AuthenticatorDetail]
}

object Authenticators extends Enumeration {
  type Authenticators = Value
  val UserPass, Twitter, Facebook, Google = Value
}


