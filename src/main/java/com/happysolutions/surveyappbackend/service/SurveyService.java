package com.happysolutions.surveyappbackend.service;

import com.happysolutions.surveyappbackend.entity.Survey;
import com.happysolutions.surveyappbackend.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Optional<Survey> getSurvey(Long surveyId){
        return surveyRepository.findById(surveyId);
    }

    public List<Survey> getSurveys(){
        return surveyRepository.findAll();
    }

    public Survey postSurvey(Survey survey){
        return surveyRepository.save(survey);
    }

}
