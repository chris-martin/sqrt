import sbt._
import Keys._

object Build extends sbt.Build {

  lazy val project = Project(id = "root", base = file(".")) settings (
    scalaVersion := "2.10.1",
    compileOrder := CompileOrder.JavaThenScala,
    fork := true,
    javaOptions in run += "-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
  )

}
