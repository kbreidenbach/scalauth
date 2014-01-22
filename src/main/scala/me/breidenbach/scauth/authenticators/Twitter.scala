package me.breidenbach.scauth.authenticators

/**
 * Date: 1/19/14
 * Time: 5:57 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
class Twitter extends OAuth {
  def authenticatorType: String = "twitter"
}

class TwitterDetail(username: Option[String], fullName: Option[String], avURL: Option[String]) extends AuthenticatorDetail {
  def authenticator: Authenticators.Authenticators = Authenticators.Twitter
  def userId: Option[String] = username
  def password: Option[String] = None
  def firstName: Option[String] = None
  def lastName: Option[String] = None
  def displayName: Option[String] = fullName
  def avatarUrl: Option[String] = avURL
}