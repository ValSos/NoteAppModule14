package com.example.controller;


import com.example.entity.Note;
import com.example.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute Note note)  {
        noteService.update(note);
        return new ModelAndView("redirect:/note/list");
    }
}
