import Dependencies._

ThisBuild / scalaVersion     := "2.13.2"
ThisBuild / version          := "1.0"

lazy val root = (project in file("."))
  .settings(
    name := "ScalaRestaurant",
    libraryDependencies += scalaTest % Test
  )
