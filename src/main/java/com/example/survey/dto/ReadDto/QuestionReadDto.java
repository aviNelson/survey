package com.example.survey.dto.ReadDto;

import lombok.Value;

import java.util.List;

@Value
public class QuestionReadDto {
    Integer id;
    String questionText;
    Integer surveyId;
    String questionType;
    List<AnswerReadDto> answers;
}
