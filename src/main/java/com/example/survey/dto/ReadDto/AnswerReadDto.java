package com.example.survey.dto.ReadDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

@Value
public class AnswerReadDto {
    Integer id;
    String content;
    Integer answeredQuestion;
}
