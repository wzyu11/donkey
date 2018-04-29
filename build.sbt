lazy val core = (project in file("donkey-core"))
  .settings(
    organization := "io.mangix",
    name := "donkey-core",
    version := "0.1",
    scalaVersion := "2.12.6")

lazy val protocol = (project in file("donkey-protocol"))
  .settings(
    organization := "io.mangix",
    name := "donkey-protocol",
    version := "0.1",
    scalaVersion := "2.12.6")

lazy val manager = (project in file("donkey-manager"))
  .settings(
    organization := "io.mangix",
    name := "donkey-manager",
    version := "0.1",
    scalaVersion := "2.12.6")

lazy val container = (project in file("donkey-container"))
  .settings(
    organization := "io.mangix",
    name := "donkey-container",
    version := "0.1",
    scalaVersion := "2.12.6")