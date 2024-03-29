package com.example.JavaDev_HW16_CI_CD.noteprocessor.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    private Long id;
    private String title;
    private String content;
}
