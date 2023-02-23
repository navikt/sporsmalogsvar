package no.nav.syfo.application.sporsmal

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

const val basePath = "/api/v1/sporsmal"
fun Route.registerSporsmalApi() {
    route(basePath) {
        get {
            call.respond(HttpStatusCode.OK)
        }
    }
}
