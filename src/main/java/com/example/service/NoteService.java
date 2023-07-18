package com.example.service;

import com.example.entity.Note;
import com.example.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        List<Note> result = (List<Note>) noteRepository.findAll();
        return result;
    }

    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Object with id " + id + " does not exist"));
    }

    public Note add(Note note) {
        Note newNote = noteRepository.save(note);
        return newNote;
    }

    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new IllegalArgumentException("Object with id " + note.getId() + " does not exist");
        }
        noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.delete(getById(id));
    }

}
