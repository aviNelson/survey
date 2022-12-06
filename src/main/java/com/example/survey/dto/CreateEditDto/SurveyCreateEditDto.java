package com.example.survey.dto.CreateEditDto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SurveyCreateEditDto {
    String name;
    LocalDateTime endDate;
    String description;
}
