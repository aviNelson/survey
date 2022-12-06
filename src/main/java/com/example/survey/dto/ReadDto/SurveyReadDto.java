package com.example.survey.dto.ReadDto;

import com.example.survey.jsonview.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class SurveyReadDto {
    @JsonView(View.NoAnswered.class)
    Integer id;
    @JsonView(View.NoAnswered.class)
    String name;
    @JsonView(View.NoAnswered.class)
    LocalDateTime startDate;
    @JsonView(View.NoAnswered.class)
    LocalDateTime endDate;
    @JsonView(View.NoAnswered.class)
    String description;

    List<QuestionReadDto> questions;
}
