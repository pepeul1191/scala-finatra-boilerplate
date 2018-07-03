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

// finatra framework
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3"
libraryDependencies += "javax.activation" % "activation" % "1.1"
libraryDependencies += "com.twitter" %% "finatra-http" % "18.6.0"
// typesafe
libraryDependencies += "com.typesafe" % "config" % "1.3.2"
// orm
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.3"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
libraryDependencies += "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3"
libraryDependencies += "org.xerial" % "sqlite-jdbc" % "3.7.2"

