package me.breidenbach.scauth.authenticators

/**
 * Date: 1/19/14
 * Time: 5:58 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
class UserPass {

}

class UserPassDetail(username: Option[String], passwd: Option[String], first: Option[String],
                      last: Option[String], fullName: Option[String], avURL: Option[String]) extends AuthenticatorDetail {
  def authenticator: Authenticators.Authenticators = Authenticators.UserPass
  def userId: Option[String] = username
  def password: Option[String] = passwd
  def firstName: Option[String] = first
  def lastName: Option[String] = last
  def displayName: Option[String] = fullName
  def avatarUrl: Option[String] = avURL
}