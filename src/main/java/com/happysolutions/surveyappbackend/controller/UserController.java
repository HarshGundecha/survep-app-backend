package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.entity.User;
import com.happysolutions.surveyappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("${api.endpoint.prefix}/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public HttpEntity<?> postUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.postUser(user));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

}
