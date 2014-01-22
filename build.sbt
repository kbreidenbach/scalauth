name := "scauth"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "com.google.oauth-client" % "google-oauth-client" % "1.17.0-rc",
  "joda-time" % "joda-time" % "2.3",
  "org.joda" % "joda-convert" % "1.2",
  "com.typesafe" % "config" % "1.0.2"
)