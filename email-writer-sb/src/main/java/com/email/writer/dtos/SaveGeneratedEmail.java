package com.email.writer.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SaveGeneratedEmail {
    private String prompt;
    private String tone;


    private String generatedContext;

}
