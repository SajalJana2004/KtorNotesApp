package com.example.ktornotesapp.notes.data

import kotlinx.serialization.Serializable

@Serializable
data class NoteTextRequest(
    val userId: Long,
    val noteTitle: String,
    val noteContent: String
)


@Serializable
data class Note(
    val noteId:Long,
    val noteTitle: String,
    val noteContent: String,
    val createdAt: String
)

@Serializable
data class NoteResponseData(
    val success: Boolean,
    val note: Note? = null,
    val notes: List<Note> = listOf(),
    val message: String? = null
)

@Serializable
data class NotesResponse(
    val data: NoteResponseData? = null,
    val errorMessage: String? = null
)

