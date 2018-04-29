lazy val commonSettings = Seq(
  organization := "io.mangix",
  version := "0.1",
  scalaVersion := "2.12.6"
)

lazy val core = (project in file("donkey-core"))
  .settings(
    commonSettings,
    name := "donkey-core"
  )

lazy val protocol = (project in file("donkey-protocol"))
  .dependsOn(core)
  .settings(
    commonSettings,
    name := "donkey-protocol"
  )

lazy val manager = (project in file("donkey-manager"))
  .dependsOn(core)
  .settings(
    commonSettings,
    name := "donkey-manager"
  )

lazy val container = (project in file("donkey-container"))
  .dependsOn(manager, protocol)
  .settings(
    commonSettings,
    name := "donkey-container"
  )