package com.example.survey.dto.ReadDto;

import com.example.survey.entity.Answer;
import com.example.survey.entity.AnswerVariant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

import java.util.List;

@Value
public class AnsweredQuestionReadDto {
    Integer id;
    Integer userId;
    Integer questionId;

    List<Answer> answers;
}
