package com.example.ktornotesapp.notes.domain.repository

import com.example.ktornotesapp.notes.domain.model.NotesResultData
import com.example.socialmediaapp.common.util.Result
internal interface NotesRepository {

    suspend fun insertNote(
        userId: Long,
        noteTitle: String,
        noteContent: String
    ): Result<NotesResultData>

    suspend fun editNote(
        userId: Long,
        noteTitle: String,
        noteContent: String
    ): Result<NotesResultData>

    suspend fun deleteNote(noteId: Long): Result<NotesResultData>
    suspend fun getUserNotes(userId: Long): Result<NotesResultData>
    suspend fun getNoteById(noteId: Long): Result<NotesResultData>
}