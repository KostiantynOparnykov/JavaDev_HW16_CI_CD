package com.example.JavaDev_HW16_CI_CD.noteprocessor.controller;

import com.example.JavaDev_HW16_CI_CD.noteprocessor.entities.Note;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.exceptions.NoteProcessingExceptions;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class NoteControllerTest {

    @Mock
    private NoteService noteService;

    @InjectMocks
    private NoteController noteController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getIndexPage() {
        String result = noteController.getIndexPage();
        assertEquals("index", result);
    }

    @Test
    void getAllNotes() {
        List<Note> mockNotes = new ArrayList<>();

        ModelAndView modelAndView = new ModelAndView("all_notes");
        when(noteService.listAll()).thenReturn(mockNotes);

        ModelAndView result = noteController.getAllNotes();
        assertEquals(modelAndView.getViewName(), result.getViewName());
    }

    @Test
    void editNote() throws NoteProcessingExceptions {
        Long id = 1L;
        Note note = new Note();

        when(noteService.getById(id)).thenReturn(note);

        ModelAndView modelAndView = new ModelAndView("edit_note");
        modelAndView.addObject("note", note);

        ModelAndView result = noteController.editNote(id);
        assertEquals(modelAndView.getViewName(), result.getViewName());
        assertEquals(modelAndView.getModel().get("note"), result.getModel().get("note"));
    }

    @Test
    void saveEditNoteById() throws NoteProcessingExceptions {
        Note note = new Note();

        String result = noteController.saveEditNoteById(note);
        verify(noteService, times(1)).update(note);
        assertEquals("redirect:/note/list", result);
    }

    @Test
    void saveCreateNote() {
        Note note = new Note();

        String result = noteController.saveCreateNote(note);
        verify(noteService, times(1)).add(note);
        assertEquals("redirect:/note/list", result);
    }

    @Test
    void deleteNoteById() throws NoteProcessingExceptions {
        Long id = 1L;

        String result = noteController.deleteNoteById(id);
        verify(noteService, times(1)).deleteById(id);
        assertEquals("redirect:/note/list", result);
    }
}
