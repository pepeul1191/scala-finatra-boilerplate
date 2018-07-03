package controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import slick.jdbc.SQLiteProfile.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import models.Departamento

class DepartamentoController extends Controller{
  get("/departamento/listar") { request: Request =>
    val departamentos = null
    var rpta = "futura rpta"
    val db = Database.forConfig("database")
    try {
      val departamentos = TableQuery[Departamento]
      var rs = new ListBuffer[Map[String, Any]]()
      db.run(departamentos.result).map(_.foreach {
        case (id, nombre) => {
          rs += Map(
            "id" -> id,
            "nombre" -> nombre
          )
        }
        println("1 ++++++++++++++++++++")
        println(rs.length)
        println("2 ++++++++++++++++++++")
      })
      println("A ++++++++++++++++++++")
      println(rs)
      println("B ++++++++++++++++++++")
    } catch {
      case e: Exception => {
        rpta = e.toString()
      }
    }finally {
      db.close
    }
    response.ok.header("a", "b").plain(rpta)
  }
}
