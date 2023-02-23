package no.nav.syfo.application.session

import no.nav.syfo.application.database.DatabaseInterface
import no.nav.syfo.application.database.toList
import java.sql.SQLException
import java.time.OffsetDateTime

const val queryCreateSession =
    """
        INSERT INTO session (
            id,
            uuid,
            created_at,
            updated_at,
            code
        ) VALUES (DEFAULT, ?, ?, ?, ?)
    """
fun DatabaseInterface.createSession(session: Session) {
    val now = OffsetDateTime.now()

    val sessionIDs = connection.prepareStatement(queryCreateSession).use {
        it.setString(1, session.uuid.toString())
        it.setObject(2, now)
        it.setObject(3, now)
        it.setString(4, session.code)
        it.executeQuery().toList { getInt("id") }
    }

    if (sessionIDs.size != 1) {
        throw SQLException("Creating dialogmotesvar failed, no rows affected.")
    }
}
