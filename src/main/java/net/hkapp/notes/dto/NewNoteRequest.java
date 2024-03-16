package net.hkapp.notes.dto;

import lombok.Data;

@Data
public class NewNoteRequest {
    private String content;
    private String type;
    private Integer clientId;
}
