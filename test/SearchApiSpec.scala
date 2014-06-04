import controllers.{SearchApi, ExternalDependencyMock}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class SearchApiSpec extends Specification {

  object TestSearchApi extends SearchApi {
    val externalDependency = new ExternalDependencyMock()
  }

  "SearchApi" should {

    "test" in new WithApplication {
      val query = Json.obj("query" -> "a query")

      val request = FakeRequest(POST, "/search")
        .withJsonBody(Json.toJson(query))
        .withHeaders("Content-Type" -> "application/json")

      val result = TestSearchApi.search.apply(request).run

      status(result) must equalTo(OK)
    }

  }

}