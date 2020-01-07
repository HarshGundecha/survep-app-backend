package com.happysolutions.surveyappbackend.service;

import com.happysolutions.surveyappbackend.entity.Answer;
import com.happysolutions.surveyappbackend.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Optional<Answer> getAnswer(Long answerId){
        return answerRepository.findById(answerId);
    }

    public Answer postAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> getAnswers(){
        return answerRepository.findAll();
    }



}
