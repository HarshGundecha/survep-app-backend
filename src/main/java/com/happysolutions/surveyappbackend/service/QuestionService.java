package com.happysolutions.surveyappbackend.service;

import com.happysolutions.surveyappbackend.entity.Question;
import com.happysolutions.surveyappbackend.entity.Survey;
import com.happysolutions.surveyappbackend.repository.QuestionRepository;
import com.happysolutions.surveyappbackend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Optional<Question> getQuestion(Long questionId){
        return questionRepository.findById(questionId);
    }

    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }

    public Question postQuestion(Question question){
        return questionRepository.save(question);
    }

}
