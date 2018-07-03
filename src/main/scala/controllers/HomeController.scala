package controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import slick.jdbc.SQLiteProfile.api._
import scala.concurrent.ExecutionContext.Implicits.global

class HomeController extends Controller {
  get("/assets/:*") { request: Request =>
    response.ok.file("/public/" + request.params("*"))
  }

  get("/") { request: Request =>
    val db = Database.forConfig("database")
    val departamentos = null
    try {
      class Departamento(tag: Tag) extends Table[(Int, String)](tag, "departamentos") {
        def id = column[Int]("id", O.PrimaryKey) // This is the primary key column
        def nombre= column[String]("nombre")
        // Every table needs a * projection with the same type as the table's type parameter
        def * = (id, nombre)
      }
      val departamentos = TableQuery[Departamento]
      println("1 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
      db.run(departamentos.result).map(_.foreach {
        case (id, nombre) =>
          println("  " + id + "\t" + nombre)
      })
      println(departamentos)
      println("2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++")
    } finally db.close
    response.ok.header("a", "b").plain(departamentos)
  }
}