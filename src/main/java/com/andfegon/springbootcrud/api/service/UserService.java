package com.andfegon.springbootcrud.api.service;

import com.andfegon.springbootcrud.api.model.User;
import com.andfegon.springbootcrud.api.exception.EntityNotFoundException;
import com.andfegon.springbootcrud.api.model.*;
import com.andfegon.springbootcrud.api.model.request.UserCreationRequest;
import com.andfegon.springbootcrud.api.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User updateUser (String id, UserCreationRequest request) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new EntityNotFoundException("User not present in the database");
        }
        User user = optionalUser.get();
        user.setUserName(request.getUserName());
        user.setAge(request.getAge());
        return userRepository.save(user);
    }

    public List<User> readUsers() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        return userList;
    }

    public User createUser(UserCreationRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User readUserById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new EntityNotFoundException("Cant find any user under given ID");
    }

}
