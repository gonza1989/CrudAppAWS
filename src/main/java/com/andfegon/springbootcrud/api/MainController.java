package com.andfegon.springbootcrud.api;

import com.andfegon.springbootcrud.api.model.*;
import com.andfegon.springbootcrud.api.repository.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/rest")
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity create() {

        User user = new User();
        user.setUserName("Andres Gonzalez");
        user.setAge("31");

        User user1 = userRepository.save(user);

        return ResponseEntity.ok().build();

    }
}