package me.breidenbach.scauth

import me.breidenbach.scauth.identifier.ScauthIdentifier

/**
 * Date: 1/19/14
 * Time: 8:29 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */

trait UserService[T <: ScauthIdentifier] {
  def save(identifier: ScauthIdentifier): Either[T, Error]
  def find(id: Int): Option[T]
  def find(username: String): Option[T]
  def findByEmail(email: String): Option[T]
}

object UserService extends UserService[ScauthIdentifier] {
  override def save(identifier: ScauthIdentifier): Either[ScauthIdentifier, Error] = {
    Right(new Error())
  }

  override def find(id: Int): Option[ScauthIdentifier] = {
    None
  }

  override def find(username: String): Option[ScauthIdentifier] = {
    None
  }

  override def findByEmail(email: String): Option[ScauthIdentifier] = {
    None
  }
}
