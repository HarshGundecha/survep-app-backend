package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.entity.Question;
import com.happysolutions.surveyappbackend.entity.Survey;
import com.happysolutions.surveyappbackend.service.QuestionService;
import com.happysolutions.surveyappbackend.service.SurveyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
    @ApiOperation(
            value = "Get Question",
            notes = "Given a questionId it returns a Question object",
            response = Question.class
    )
    public ResponseEntity<?> getQuestion(@ApiParam(value="questionId of the question to be fetched", required = true) @PathVariable Long questionId){
        return ResponseEntity.ok(questionService.getQuestion(questionId));
    }

    @GetMapping("/")
    public ResponseEntity<?> getQuestions() {
        return ResponseEntity.ok(questionService.getQuestions());
    }

}
