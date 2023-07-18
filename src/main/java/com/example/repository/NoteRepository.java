package com.example.repository;

import com.example.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
