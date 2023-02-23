CREATE TABLE SESSION
(
    id                              SERIAL PRIMARY KEY,
    uuid                            CHAR(36) NOT NULL UNIQUE,
    created_at                      TIMESTAMPTZ NOT NULL,
    updated_at                      TIMESTAMPTZ NOT NULL,
    code                            VARCHAR(16) NOT NULL UNIQUE
);

CREATE INDEX IX_SESSION_CODE ON SESSION (code);

CREATE TABLE QUESTION
(
    id                              SERIAL PRIMARY KEY,
    session_id                      INTEGER REFERENCES SESSION (id) ON DELETE CASCADE,
    uuid                            CHAR(36) NOT NULL UNIQUE,
    created_at                      TIMESTAMPTZ NOT NULL,
    updated_at                      TIMESTAMPTZ NOT NULL,
    question_text                   TEXT NOT NULL
);

CREATE INDEX IX_QUESTION_SESSION_ID ON QUESTION (session_id);
