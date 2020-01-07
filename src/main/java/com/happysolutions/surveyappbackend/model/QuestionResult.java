package com.happysolutions.surveyappbackend.model;

import lombok.Data;

@Data
public class QuestionResult {
    private Long questionId;
    private String questionText;
    private Long trueCount;
    private Long falseCount;
}
