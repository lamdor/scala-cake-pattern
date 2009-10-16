import sbt._

class CakePatternProject(info: ProjectInfo) extends DefaultProject(info) {
  val specs = "org.scala-tools.testing" % "specs" % "1.6.0" % "test"
  val mockito = "org.mockito" % "mockito-all" % "1.8.0" % "test"
}
