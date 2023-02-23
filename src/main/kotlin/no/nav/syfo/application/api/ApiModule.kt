package no.nav.syfo.application.api

import io.ktor.server.application.*
import io.ktor.server.routing.*
import no.nav.syfo.application.ApplicationState
import no.nav.syfo.application.database.DatabaseInterface
import no.nav.syfo.application.metric.registerMetricApi
import no.nav.syfo.application.session.SessionService
import no.nav.syfo.application.session.registerSessionApi
import no.nav.syfo.application.sporsmal.registerSporsmalApi

fun Application.apiModule(
    applicationState: ApplicationState,
    database: DatabaseInterface,
) {
    installMetrics()
    installCallId()
    installContentNegotiation()
    installStatusPages()

    val sessionService = SessionService(database = database)

    routing {
        registerPodApi(
            applicationState = applicationState,
            database = database
        )
        registerMetricApi()
        registerSporsmalApi()
        registerSessionApi(sessionService = sessionService)
    }
}
