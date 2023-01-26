package com.example.notes.data.note

import com.example.notes.database.NotesDb
import com.example.notes.domain.note.Note
import com.example.notes.domain.note.NoteDataSource
import com.example.notes.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(
    db: NotesDb
) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map { it.toNote() }
    }

    override suspend fun deleteNote(id: Long) {
        return queries.deleteNote(id)
    }

}