package com.example.ktornotesapp.notes.domain.model

import com.example.ktornotesapp.notes.data.Note

data class NotesResultData(
    val note: Note? = null,
    val notes: List<Note> = listOf(),
)