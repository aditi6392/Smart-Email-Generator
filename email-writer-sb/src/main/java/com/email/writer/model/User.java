package com.email.writer.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Add this
    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
}
