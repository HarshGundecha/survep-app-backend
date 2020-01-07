package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.entity.Answer;
import com.happysolutions.surveyappbackend.entity.Question;
import com.happysolutions.surveyappbackend.service.AnswerService;
import com.happysolutions.surveyappbackend.service.QuestionService;
import com.happysolutions.surveyappbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("${api.endpoint.prefix}/answer")
public class AnswerController {
    
    @Autowired
    private AnswerService answerService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private UserService userService;

    @PostMapping("/{questionId}")
    public boolean postAnswer(@Valid @RequestBody Answer answer, @PathVariable Long questionId) {
        Question question = questionService.getQuestion(questionId).get();

        if(question!=null)
        {
            answer.setUser(userService.getUserFromRequest());
            question.getAnswerSet().add(answer);
            questionService.postQuestion(question);
            return true;
        }
        else
            return false;
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<?> getAnswer(@PathVariable Long answerId) {
        return ResponseEntity.ok(answerService.getAnswer(answerId));
    }

    @GetMapping
    public ResponseEntity<?> getAnswers() {
        return ResponseEntity.ok(answerService.getAnswers());
    }

}
