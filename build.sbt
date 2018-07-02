import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "softweb.pe",
      scalaVersion := "2.12.6",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "finatra.app",
    libraryDependencies += scalaTest % Test
  )

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
libraryDependencies += "javax.activation" % "activation" % "1.1"
libraryDependencies += "com.twitter" %% "finatra-http" % "18.6.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.2"