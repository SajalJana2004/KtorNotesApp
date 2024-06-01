package com.example.ktornotesapp.notes.data

import com.example.ktornotesapp.common.KtorApi
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody

internal class NotesService : KtorApi() {

    suspend fun insertNote(request: NoteTextRequest): NotesResponse = client.post {
        endPoint(path = "note/create")
        setBody(request)
    }.body()

    suspend fun editNote(request: NoteTextRequest): NotesResponse = client.post {
        endPoint(path = "note/edit")
        setBody(request)
    }.body()

    suspend fun deleteNoteById(noteId: Long): NotesResponse = client.delete {
        endPoint(path = "/note/$noteId")
    }.body()

    suspend fun getNoteById(noteId: Long): NotesResponse = client.get {
        endPoint(path = "/note/$noteId")
    }.body()


    suspend fun getUserNotes(userId: Long): NotesResponse = client.get {
        endPoint(path = "/notes/$userId")
    }.body()
}