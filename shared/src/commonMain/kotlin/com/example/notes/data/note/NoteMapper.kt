package com.example.notes.data.note

import com.example.notes.domain.note.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        created = Instant.fromEpochSeconds(created).toLocalDateTime(TimeZone.currentSystemDefault())
    )
}