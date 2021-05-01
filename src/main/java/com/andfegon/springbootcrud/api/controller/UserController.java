package com.andfegon.springbootcrud.api.controller;


import com.andfegon.springbootcrud.api.service.UserService;
import com.andfegon.springbootcrud.api.model.User;
import com.andfegon.springbootcrud.api.model.request.UserCreationRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser (@RequestBody UserCreationRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> readUser () {
        return ResponseEntity.ok(userService.readUsers());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> readBook (@PathVariable String userId) {
        return ResponseEntity.ok(userService.readUserById(userId));
    }

    @PatchMapping("/user/{userId}")
    public ResponseEntity<User> updateUser (@RequestBody UserCreationRequest request, @PathVariable String userId) {
        return ResponseEntity.ok(userService.updateUser(userId, request));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser (@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

}


