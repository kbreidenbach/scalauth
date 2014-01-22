package me.breidenbach.scalauth.identifier

import me.breidenbach.scalauth.authenticators.AuthenticatorDetail

/**
 * Date: 1/19/14
 * Time: 5:37 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
trait ScauthIdentifier {
  def id: Long
  def username: String
  def firstName: String
  def lastName: String
  def displayName: String
  def email: String
  def avatarURL: Option[String]
  def authenticators: Option[Array[AuthenticatorDetail]]
}

