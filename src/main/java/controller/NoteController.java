package controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.NoteRepository;
import service.NoteService;

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
}
