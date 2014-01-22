package me.breidenbach.scalauth

import me.breidenbach.scalauth.authenticators.Twitter

/**
 * Date: 1/19/14
 * Time: 7:36 PM
 * Copyright 2014 Kevin E. Breidenbach
 * @author Kevin E. Breidenbach
 */
object Test {
  def main(args: Array[String]) {
    println("Testing...")
    println("Auth: " + Configurator.defaultAuthTokenExpirationHours)
    println("Reset: " + Configurator.defaultResetTokenExpirationHours)

    val twitter = new Twitter
    twitter.authenticate()

  }
}
