package no.nav.syfo.application.session

import no.nav.syfo.application.database.DatabaseInterface

class SessionService(
    private val database: DatabaseInterface,
) {
    fun createSession(session: Session) {
        database.createSession(session)
    }
}
