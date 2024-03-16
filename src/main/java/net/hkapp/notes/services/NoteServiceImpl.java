package net.hkapp.notes.services;

import io.micrometer.common.util.StringUtils;
import net.hkapp.notes.dao.ClientDao;
import net.hkapp.notes.dao.NoteDao;
import net.hkapp.notes.dto.NewNoteRequest;
import net.hkapp.notes.entity.Client;
import net.hkapp.notes.entity.Note;
import net.hkapp.notes.services.contracts.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private ClientDao clientDao;

    @Override
    public void createNote(NewNoteRequest req) {
        Note newNote = new Note();
        if (req.getClientId() != null) {
            Client c = null;
            Optional<Client> opt = clientDao.findById(req.getClientId());
            if (opt.isPresent()) {
                c = opt.get();
                newNote.setClient(c);
            } else {
                System.out.println("Client not found");
            }
        }

        newNote.setContent(req.getContent());
        newNote.setType(req.getType());

        noteDao.save(newNote);
        System.out.println("Record Created Successfully");
    }

    @Override
    public Note findNoteById(Integer noteId) {
        Note result = null;
        Optional<Note> opt = noteDao.findById(noteId);
        if(opt.isPresent()) {
            result = opt.get();
        }
        return result;
    }

    @Override
    public void updateNote(Note noteUpdates) {
        Note result = null;
        Optional<Note> opt = noteDao.findById(noteUpdates.getNoteId());
        if (opt.isPresent()) {
            result = opt.get();
            if (StringUtils.isNotEmpty(noteUpdates.getType())) {
                result.setType(noteUpdates.getType());
            }
            if (StringUtils.isNotEmpty(noteUpdates.getContent())) {
                result.setContent(noteUpdates.getContent());
            }
            result.setUpdatedAt(OffsetDateTime.now());
            noteDao.save(result);
        } else {
            System.out.println("Record not found");
        }
    }

    @Override
    public void deleteNote(Integer noteId) {
        noteDao.deleteById(noteId);
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> results = noteDao.findAll();
        return results;
    }

    @Override
    public List<Note> findByContent(String query) {
        List<Note> results = noteDao.findByContent(query);
        return results;
    }
}
