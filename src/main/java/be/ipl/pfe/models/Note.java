package be.ipl.pfe.models;

import lombok.Data;

@Data
public class Note {
    private String subject;
    private String content;

    public Note(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }
}