package com.email.writer.service;

import com.email.writer.dtos.SaveGeneratedEmail;
import com.email.writer.model.GeneratedEmail;
import com.email.writer.model.User;
import com.email.writer.repository.GeneratedEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneratedEmailService {

    private final GeneratedEmailRepository generatedEmailRepository;

    // ✅ Save a generated email using DTO and User
    public GeneratedEmail saveGeneratedEmail(SaveGeneratedEmail request, User user) {
        GeneratedEmail email = new GeneratedEmail();

        email.setPrompt(request.getPrompt());
        email.setTone(request.getTone());
        email.setGeneratedContext(request.getGeneratedContext());
        email.setUser(user);

        return generatedEmailRepository.save(email);
    }

    // ✅ Get all generated emails for a given user
    public List<GeneratedEmail> getAllGeneratedEmailService(User user) {
        return generatedEmailRepository.findByUser(user);
    }
}
