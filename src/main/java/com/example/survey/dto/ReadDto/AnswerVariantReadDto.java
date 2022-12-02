package com.example.survey.dto.ReadDto;

import lombok.Value;

@Value
public class AnswerVariantReadDto {
    Integer id;
    String content;
    Integer questionId;
}
