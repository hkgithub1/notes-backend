package net.hkapp.notes.controller;

import net.hkapp.notes.dto.NewNoteRequest;
import net.hkapp.notes.entity.Note;
import net.hkapp.notes.services.contracts.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/backend/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping(value = "/create-note", produces = "application/json")
    public void createNote(@RequestBody NewNoteRequest req) {
        noteService.createNote(req);
    }

    @GetMapping(value = "/find-note-by-id/{noteId}", produces = "application/json")
    public Note findNoteById(@PathVariable Integer noteId) {
        return noteService.findNoteById(noteId);
    }

    @PutMapping(value = "/update-note", produces = "application/json")
    public void updateNote(@RequestBody Note noteUpdates) {
        noteService.updateNote(noteUpdates);
    }

    @DeleteMapping(value = "/delete-note/{noteId}", produces = "application/json")
    public void deleteEmployee(@PathVariable Integer noteId) {
        noteService.deleteNote(noteId);
    }

    @GetMapping(value = "/get-all-notes", produces = "application/json")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping(value = "/find-by-content", produces = "application/json")
    public List<Note> findByContent(@RequestParam("query") String query) {
        return noteService.findByContent(query);
    }

}
