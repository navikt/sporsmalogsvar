package no.nav.syfo.testhelper

import no.nav.syfo.application.ApplicationState
import no.nav.syfo.application.Environment
import no.nav.syfo.application.database.DatabaseEnvironment

fun testEnvironment() = Environment(
    database = DatabaseEnvironment(
        host = "localhost",
        port = "5432",
        name = "sporsmalogsvar_dev",
        username = "username",
        password = "password",
    ),
)

fun testAppState() = ApplicationState(
    alive = true,
    ready = true,
)
