val scalatest = "org.scalatest" %% "scalatest" % "2.2.6" % "test"
val scalaxml = "org.scala-lang.modules" %% "scala-xml" % "1.0.4"

lazy val commonSettings = Seq(
  organization := "net.softwareminds",
  version := "0.1.0",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "nine-mens-morris",
    libraryDependencies ++= Seq(scalatest, scalaxml)
  )
