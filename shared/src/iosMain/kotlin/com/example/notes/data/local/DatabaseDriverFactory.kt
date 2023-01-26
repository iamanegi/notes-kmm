package com.example.notes.data.local

import com.example.notes.database.NotesDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(NotesDb.Schema, "note.db")
    }
}