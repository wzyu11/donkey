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

lazy val agent = (project in file("donkey-agent"))
  .dependsOn(core)
  .settings(
    commonSettings,
    name := "donkey-agent"
  )

lazy val container = (project in file("donkey-container"))
  .dependsOn(agent, protocol)
  .settings(
    commonSettings,
    name := "donkey-container"
  )