package no.nav.syfo.application.session

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

const val basePath = "/api/v1/session"

fun Route.registerSessionApi(
    sessionService: SessionService,
) {
    route(basePath) {
        post {
            val sessionDTO = call.receive<SessionDTO>()

            sessionService.createSession(sessionDTO.toSession())
        }
    }
}