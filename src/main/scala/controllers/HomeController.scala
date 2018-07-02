package controllers

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

class HomeController extends Controller {
  get("/") { request: Request =>
    response.ok.header("a", "b").plain("hola mundo")
  }
}