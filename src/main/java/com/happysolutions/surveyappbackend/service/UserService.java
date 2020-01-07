package com.happysolutions.surveyappbackend.service;

import com.happysolutions.surveyappbackend.config.JwtTokenUtil;
import com.happysolutions.surveyappbackend.entity.User;
import com.happysolutions.surveyappbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

//    @Autowired
//    private FollowerService followerService;

    public User save(User user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserFromRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization").split(" ")[1];
        String email = jwtTokenUtil.getUsernameFromToken(token);
//        return setFollowersFollowingCount(userRepository.findByEmail(email)); // will create a DETACHED instance
        return userRepository.findByEmail(email);
    }
    public User getUserFromEmail(String username) {
        return userRepository.findByEmail(username);
    }



    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

//    public List<User> getUserBySimilarName(String name){
//        return userRepository.findUserBySimilarName(name);
//    }

//    public List<User> getUsersByUsersId(List<Long> usersId){
//        return userRepository.findAllById(usersId);
//    }

}
