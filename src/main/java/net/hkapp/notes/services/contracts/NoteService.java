package net.hkapp.notes.services.contracts;

import net.hkapp.notes.dto.NewNoteRequest;
import net.hkapp.notes.entity.Note;

import java.util.List;

public interface NoteService {
    void createNote(NewNoteRequest req);
    Note findNoteById(Integer noteId);
    void updateNote(Note noteUpdates);
    void deleteNote(Integer noteId);
    List<Note> getAllNotes();
    List<Note> findByContent(String query);

}
