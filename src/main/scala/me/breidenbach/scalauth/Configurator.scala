package me.breidenbach.scalauth

import com.typesafe.config.{ConfigException, ConfigFactory}

/**
 * Date: 1/19/14
 * Time: 7:15 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
object Configurator {
  val configApp = "scalauth"
  val defaultAuthTokenExpHours = "scalauth.authtoken.expirationhours"
  val defaultResetTokenExpHours = "scalauth.resettoken.expirationhours"
  val config = ConfigFactory.load(configApp)

  def defaultAuthTokenExpirationHours: Int = {
    config.getInt(defaultAuthTokenExpHours)
  }

  def defaultResetTokenExpirationHours: Int = {
    config.getInt(defaultResetTokenExpHours)
  }

  def get(prefix: String, key: String): Option[String] = {
    try {
      Some(config.getString(configApp + "." + prefix + "." + key))
    } catch {
      case e: ConfigException.Missing => None
      case e: ConfigException.WrongType => None
    }

  }
}
