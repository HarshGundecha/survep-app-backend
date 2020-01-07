package com.happysolutions.surveyappbackend.model;

import com.happysolutions.surveyappbackend.model.QuestionResult;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public class SurveyResult {
    private Long surveyId;
    private Set<QuestionResult> questionResultSet = new HashSet<>();
}
