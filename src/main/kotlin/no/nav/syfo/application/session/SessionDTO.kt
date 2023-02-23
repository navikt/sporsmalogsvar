package no.nav.syfo.application.session

import java.util.UUID

data class SessionDTO(
    val code: String,
)

fun SessionDTO.toSession() = Session(
    uuid = UUID.randomUUID(),
    code = code,
)
