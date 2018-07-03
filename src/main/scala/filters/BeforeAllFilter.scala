package filters

import com.twitter.finagle.{Service, SimpleFilter}
import com.twitter.finagle.http.{Request, Response}
import com.twitter.util.Future
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

class BeforeAllFilter extends SimpleFilter[Request, Response] {
  override def apply(request: Request, service: Service[Request, Response]): Future[Response] = service(request).map {
    val conf: Config = ConfigFactory.load()
    response => response.headerMap
      .add("X-Powered-By", "Ubuntu")
      .add("access-control-allow-origin", "*")
      .add(conf.getString("csrf.key"), conf.getString("csrf.secret"))
      .add("access-control-allow-headers", "accept, content-type")
      .add("access-control-allow-methods", "GET,HEAD,POST,DELETE,OPTIONS,PUT,PATCH")
      response
  }
}
