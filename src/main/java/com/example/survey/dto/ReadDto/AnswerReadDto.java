package com.example.survey.dto.ReadDto;

import com.example.survey.entity.Question;
import com.example.survey.entity.Survey;
import com.example.survey.entity.User;
import lombok.*;

@Value
public class AnswerReadDto {
    Integer surveyId;
    Integer questionId;
    Integer userId;
    String content;
}
