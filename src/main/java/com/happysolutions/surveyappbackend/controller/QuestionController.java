package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.entity.Question;
import com.happysolutions.surveyappbackend.entity.Survey;
import com.happysolutions.surveyappbackend.service.QuestionService;
import com.happysolutions.surveyappbackend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("${api.endpoint.prefix}/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

//    @PostMapping("/")
//    public ResponseEntity<?> postQuestion(@RequestBody Question question) {
//        return ResponseEntity.ok(questionService.postQuestion(question));
//    }

    @GetMapping("/{questionId}")
    public ResponseEntity<?> getQuestion(@PathVariable Long questionId) {
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(questionService.getQuestions());
    }

}
