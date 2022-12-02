package com.example.survey.dto.ReadDto;

import lombok.Value;

@Value
public class QuestionReadDto {
    Integer id;
    String questionText;
    Integer surveyId;
    String questionType;
}
