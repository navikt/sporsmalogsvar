package no.nav.syfo.application.session

import java.util.UUID

data class Session(
    val uuid: UUID,
    val code: String,
)
