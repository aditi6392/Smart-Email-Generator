package com.email.writer.repository;

import com.email.writer.model.GeneratedEmail;
import com.email.writer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneratedEmailRepository  extends JpaRepository<GeneratedEmail,Long> {
    List<GeneratedEmail> findByUser(User user);

}
