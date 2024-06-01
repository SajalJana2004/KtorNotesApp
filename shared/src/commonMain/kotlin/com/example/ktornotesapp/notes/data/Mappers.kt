package com.example.ktornotesapp.notes.data

import com.example.ktornotesapp.notes.domain.model.NotesResultData

internal fun NoteResponseData.toNoteResultData():NotesResultData{
    return NotesResultData(note,notes)
}