package me.breidenbach.scalauth.tokens

/**
 * Date: 1/19/14
 * Time: 6:09 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
import org.joda.time.DateTime

trait Token {
  def uuid: String
  def creationDate: DateTime
  def expirationDate: DateTime
  def isExpired: Boolean = {
    expirationDate.isBeforeNow
  }
}

class AuthToken(uid: String, created: DateTime = DateTime.now, expires: DateTime = DateTime.now.plusHours(72)) extends Token {
  def uuid = uid
  def creationDate = created
  def expirationDate = expires
}

class ResetToken(uid:String, created: DateTime = DateTime.now, expires: DateTime = DateTime.now.plusHours(24)) extends Token {
  def uuid = uid
  def creationDate = created
  def expirationDate = expires
}
