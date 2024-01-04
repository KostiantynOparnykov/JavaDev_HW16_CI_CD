package com.example.JavaDev_HW16_CI_CD.noteprocessor.exceptions;

public class NoteProcessingExceptions extends Exception{
    public NoteProcessingExceptions(Long id){
        super("Note not found " + id );
    }
}
