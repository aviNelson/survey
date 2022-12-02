package com.example.survey.dto.ReadDto;

import com.example.survey.enums.Status;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class SurveyReadDto {
    Integer id;
    String name;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String description;
}
