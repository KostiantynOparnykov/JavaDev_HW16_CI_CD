package com.example.JavaDev_HW16_CI_CD.noteprocessor.controller;


import com.example.JavaDev_HW16_CI_CD.noteprocessor.entities.Note;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.exceptions.NoteProcessingExceptions;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping()
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes(){
        ModelAndView result = new ModelAndView("all_notes");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView editNote(@RequestParam("id") Long id) throws NoteProcessingExceptions {
        ModelAndView result = new ModelAndView("edit_note");
        Note note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/edit")
    public String saveEditNoteById(@ModelAttribute("note") Note note) throws NoteProcessingExceptions {
        noteService.update(note);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public ModelAndView createNote() {
        return new ModelAndView("create_note", "note", new Note());
    }

    @PostMapping("/create")
    public String saveCreateNote(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
    @PostMapping("/delete")
    public String deleteNoteById(@RequestParam("id") Long id) throws NoteProcessingExceptions {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
}
