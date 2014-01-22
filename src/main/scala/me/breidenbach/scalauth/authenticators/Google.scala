package me.breidenbach.scalauth.authenticators

/**
 * Date: 1/19/14
 * Time: 5:57 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
class Google {

}

class GoogleDetail(username: Option[String], first: Option[String], last: Option[String],
                     fullName: Option[String], avURL: Option[String]) extends AuthenticatorDetail {
  def authenticator: Authenticators.Authenticators = Authenticators.Google
  def userId: Option[String] = username
  def password: Option[String] = None
  def firstName: Option[String] = first
  def lastName: Option[String] = last
  def displayName: Option[String] = fullName
  def avatarUrl: Option[String] = avURL
}