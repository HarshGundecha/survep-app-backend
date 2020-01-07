package com.happysolutions.surveyappbackend.service;

import com.happysolutions.surveyappbackend.entity.User;
import com.happysolutions.surveyappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User postUser(User user) {
        return userRepository.save(user);
    }

}