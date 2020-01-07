package com.happysolutions.surveyappbackend.controller;

import com.happysolutions.surveyappbackend.entity.Question;
import com.happysolutions.surveyappbackend.entity.Survey;
import com.happysolutions.surveyappbackend.entity.User;
import com.happysolutions.surveyappbackend.model.QuestionResult;
import com.happysolutions.surveyappbackend.model.SurveyResult;
import com.happysolutions.surveyappbackend.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("${api.endpoint.prefix}/survey")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @PostMapping
    public ResponseEntity<?> postSurvey(@Valid @RequestBody Survey survey) {
        return ResponseEntity.ok(surveyService.postSurvey(survey));
    }

    @GetMapping("/{surveyId}")
    public ResponseEntity<?> getSurvey(@PathVariable Long surveyId) {
        return ResponseEntity.ok(surveyService.getSurvey(surveyId));
    }

    @GetMapping
    public ResponseEntity<?> getSurveys() {
        return ResponseEntity.ok(surveyService.getSurveys());
    }

    @GetMapping("/result/{surveyId}")
    public ResponseEntity<?> getResult(@PathVariable Long surveyId){
        Survey survey = surveyService.getSurvey(surveyId).get();
        Set<Question> questions = survey.getQuestionSet();
        SurveyResult surveyResult = new SurveyResult();
        HashSet<QuestionResult> questionResults = new HashSet<>();
        for(Question question : questions){
            Long trueCount = question.getAnswerSet().stream().filter(answer -> answer.getAnswerValue()).count();
            Long falseCount = question.getAnswerSet().stream().filter(answer -> !answer.getAnswerValue()).count();
            QuestionResult questionResult = new QuestionResult();
            questionResult.setQuestionId(question.getQuestionId());
            questionResult.setQuestionText(question.getQuestionText());
            questionResult.setTrueCount(trueCount);
            questionResult.setFalseCount(falseCount);
            questionResults.add(questionResult);
        }
        surveyResult.setQuestionResultSet(questionResults);
        return ResponseEntity.ok(surveyResult);
    }

}