package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.config.JwtTokenUtil;
import com.happysolutions.surveyappbackend.entity.User;
import com.happysolutions.surveyappbackend.model.JwtResponse;
import com.happysolutions.surveyappbackend.service.JwtUserDetailsService;
import com.happysolutions.surveyappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.dssec4.tweetitbackend.service.UserFollowService;

@RestController
@RequestMapping("${api.endpoint.prefix}/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) throws Exception {
//        return ResponseEntity.ok(userService.save(user));
        userService.save(user);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(user.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
//		System.out.println(userDetails.getUsername()+" is my name");
        Map<String, Object> mymap = new HashMap();
        mymap.put("token",new JwtResponse(token).getToken());
        mymap.put("user",user);
        return ResponseEntity.ok(mymap);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        Map<String, Object> mymap = new HashMap();
        mymap.put("users",userService.getUsers());
        return ResponseEntity.ok(mymap);
    }

}