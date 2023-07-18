package com.example.controller;


import com.example.entity.Note;
import com.example.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getListOfNotes() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteNoteById(@PathVariable("id") long id) {
        noteService.deleteById(id);
        return new ModelAndView("redirect:/note/list");
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(@RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/edit", consumes = "application/x-www-form-urlencoded")
    public ModelAndView editNote(@RequestParam Map<String, String> reqParams) {
        Note note = new Note(Long.parseLong(reqParams.get("id")), reqParams.get("title"),reqParams.get("content"));
        noteService.update(note);
        ModelAndView modelAndView = new ModelAndView("redirect:/note/list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }
}
