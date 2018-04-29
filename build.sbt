lazy val donkey_protocol = (project in file("donkey-protocol"))
  .settings(
    organization := "io.mangix",
    name := "donkey-protocol",
    version := "0.1",
    scalaVersion := "2.12.6")

lazy val donkey_core = (project in file("donkey-core"))
  .settings(
    organization := "io.mangix",
    name := "donkey-core",
    version := "0.1",
    scalaVersion := "2.12.6")