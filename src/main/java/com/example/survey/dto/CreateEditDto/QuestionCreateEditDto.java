package com.example.survey.dto.CreateEditDto;

import lombok.Value;

@Value
public class QuestionCreateEditDto {
    String questionText;
//    Integer surveyId;
    String questionType;
}
