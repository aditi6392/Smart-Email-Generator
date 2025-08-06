package com.email.writer.controller;

import com.email.writer.dtos.SaveGeneratedEmail;
import com.email.writer.model.GeneratedEmail;
import com.email.writer.model.User;
import com.email.writer.repository.UserRepository;
import com.email.writer.service.GeneratedEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class GeneratedEmailController {

    private final GeneratedEmailService generatedEmailService;
    private final UserRepository userRepository;

    @PostMapping("/save")
    public ResponseEntity<?> saveGeneratedEmail(@RequestBody SaveGeneratedEmail request, Principal principal) {
        String username = principal.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found"));

        generatedEmailService.saveGeneratedEmail(request, user);

        return ResponseEntity.ok("Email saved successfully");
    }


    @GetMapping("/all")
    public ResponseEntity<List<GeneratedEmail>> getUserGeneratedEmails(Principal principal){
        String username = principal.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found"));

        List<GeneratedEmail> emails = generatedEmailService.getAllGeneratedEmailService(user);
        return ResponseEntity.ok(emails);
    }
}
