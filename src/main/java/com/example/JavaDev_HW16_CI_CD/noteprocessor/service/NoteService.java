package com.example.JavaDev_HW16_CI_CD.noteprocessor.service;

import com.example.JavaDev_HW16_CI_CD.noteprocessor.entities.Note;
import com.example.JavaDev_HW16_CI_CD.noteprocessor.exceptions.NoteProcessingExceptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService implements NoteServiceInterface{
    private final List<Note> noteList = new ArrayList<>();

    @Override
    public List<Note> listAll() {
        return noteList;
    }

    private long generateId(){
        if(noteList.isEmpty()){
            return 0L;
        }
        return noteList.size() +1;
    }

    @Override
    public Note add(Note note) {
        Long id = generateId();
        note.setId(id);
        noteList.add(note);
        return note;
    }

    @Override
    public void deleteById(Long id) throws NoteProcessingExceptions {
        Note note = getById(id);
        if(note == null){
            throw new NoteProcessingExceptions(id);
        }
        noteList.remove(note);
    }

    @Override
    public void update(Note note) throws NoteProcessingExceptions {
        Note exiistingNote = getById(note.getId());
        if(exiistingNote == null){
            throw new NoteProcessingExceptions(note.getId());
        }
        exiistingNote.setTitle(note.getTitle());
        exiistingNote.setContent(note.getContent());
    }

    @Override
    public Note getById(Long id) throws NoteProcessingExceptions {
        for(Note note:noteList){
            if(note.getId() == id){
                return note;
            }
        }
        throw new NoteProcessingExceptions(id);
    }
}
