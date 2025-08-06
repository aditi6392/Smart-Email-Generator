package com.email.writer.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "generated_email")
public class GeneratedEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;
    private String tone;

    @Lob
    private String generatedContext;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
