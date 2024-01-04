package com.example.JavaDev_HW16_CI_CD.noteprocessor.service;

import com.example.JavaDev_HW16_CI_CD.noteprocessor.entities.Note;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.exceptions.NoteProcessingExceptions;

import java.util.List;

public interface NoteServiceInterface {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(Long id) throws NoteProcessingExceptions;
    void update(Note note) throws NoteProcessingExceptions;
    Note getById(Long id) throws NoteProcessingExceptions;
}
