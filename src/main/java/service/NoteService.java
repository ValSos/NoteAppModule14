package service;

import entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.NoteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll(){
        List<Note> result = (List<Note>) noteRepository.findAll();
        return result;
    }
}
