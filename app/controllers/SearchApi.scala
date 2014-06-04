package controllers

import play.api.mvc.{Action, Controller}
import scala.concurrent.Future

trait SearchApi extends Controller {
  import scala.concurrent.ExecutionContext.Implicits.global
  val externalDependency: ExternalDependency

  def search = Action.async(parse.json) { implicit request =>
    Future(Ok)
  }
}

object SearchApi extends SearchApi {
  val externalDependency = new ExternalDependencyImpl()
}