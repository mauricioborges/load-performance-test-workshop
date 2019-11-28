import io.gatling.core.Predef._ //using this makes your job easier
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http.baseUrl("http://localhost:9966/petclinic")

  val scn = scenario("Basic Load").exec(http("request_swagger_because_im_stranger").get("/"))

    setUp(scn.inject(rampUsers(5) during (1 minute)).throttle(reachRps(100) in (10 seconds), holdFor(1 minute))
      .protocols(httpProtocol))
    .assertions(global.responseTime.max.lte(500))


  //como eu testo: manter 200 usuários por vez por X minutos?



  }
