package com.example.notes.data.local

import android.content.Context
import com.example.notes.database.NotesDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NotesDb.Schema, context, "note.db")
    }
}