package com.example.ktornotesapp.notes.data


import com.example.ktornotesapp.notes.domain.model.NotesResultData
import com.example.ktornotesapp.notes.domain.repository.NotesRepository
import com.example.socialmediaapp.common.util.DispatcherProvider
import kotlinx.coroutines.withContext
import com.example.socialmediaapp.common.util.Result

internal class NotesRepositoryImpl(
    private val dispatcher: DispatcherProvider, private val notesService: NotesService
) : NotesRepository {

    override suspend fun insertNote(
        userId: Long, noteTitle: String, noteContent: String
    ): Result<NotesResultData> {
        return withContext(dispatcher.io) {
            try {
                val request = NoteTextRequest(userId, noteTitle, noteContent)
                val notesResponse = notesService.insertNote(request)
                if (notesResponse.data == null) {
                    Result.Error(
                        message = notesResponse.errorMessage!!
                    )
                } else {
                    Result.Success(
                        data = notesResponse.data.toNoteResultData()
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Oops, we could not send your request, try later!"
                )
            }
        }
    }

    override suspend fun editNote(
        userId: Long, noteTitle: String, noteContent: String
    ): Result<NotesResultData> {
        return withContext(dispatcher.io) {
            try {
                val request = NoteTextRequest(userId, noteTitle, noteContent)
                val notesResponse = notesService.editNote(request)
                if (notesResponse.data == null) {
                    Result.Error(
                        message = notesResponse.errorMessage!!
                    )
                } else {
                    Result.Success(
                        data = notesResponse.data.toNoteResultData()
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Oops, we could not send your request, try later!"
                )
            }
        }
    }

    override suspend fun deleteNote(noteId: Long): Result<NotesResultData> {
        return withContext(dispatcher.io) {
            try {
                val notesResponse = notesService.deleteNoteById(noteId)
                if (notesResponse.data == null) {
                    Result.Error(
                        message = notesResponse.errorMessage!!
                    )
                } else {
                    Result.Success(
                        data = notesResponse.data.toNoteResultData(),
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Oops, we could not send your request, try later!"
                )
            }
        }
    }

    override suspend fun getUserNotes(userId: Long): Result<NotesResultData> {
        return withContext(dispatcher.io) {
            try {
                val notesResponse = notesService.deleteNoteById(userId)
                if (notesResponse.data == null) {
                    Result.Error(
                        message = notesResponse.errorMessage!!
                    )
                } else {
                    Result.Success(
                        data = notesResponse.data.toNoteResultData(),
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Oops, we could not send your request, try later!"
                )
            }
        }
    }

    override suspend fun getNoteById(noteId: Long): Result<NotesResultData> {
        return withContext(dispatcher.io) {
            try {
                val notesResponse = notesService.deleteNoteById(noteId)
                if (notesResponse.data == null) {
                    Result.Error(
                        message = notesResponse.errorMessage!!
                    )
                } else {
                    Result.Success(
                        data = notesResponse.data.toNoteResultData(),
                    )
                }
            } catch (e: Exception) {
                Result.Error(
                    message = "Oops, we could not send your request, try later!"
                )
            }
        }
    }

}