package com.example.survey.dto.CreateEditDto;

import com.example.survey.entity.Answer;
import lombok.Value;

import java.util.List;
@Value
public class AnsweredQuestionCreateEditDto {
    Integer userId;//брать из принципла секьюрети
    List<Answer> answers;
}
