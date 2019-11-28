import io.gatling.core.Predef._ //using this makes your job easier
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http.baseUrl("http://localhost:9966/petclinic")

  val scn = scenario("Basic Load").exec(http("request_swagger_because_im_stranger").get("/"))



    setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
  }
