package com.example.survey.service;

import com.example.survey.dto.CreateEditDto.QuestionCreateEditDto;
import com.example.survey.dto.ReadDto.QuestionReadDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    public List<QuestionReadDto> findBySurveyId(Integer surveyId);

    public Optional<QuestionReadDto> findBySurveyIdAndId(Integer surveyId, Integer id);

    public QuestionReadDto create(Integer surveyId,QuestionCreateEditDto questionCreateEditDto);

    public Optional<QuestionReadDto> update(Integer id, QuestionCreateEditDto questionCreateEditDto);

    public boolean delete(Integer id);
}
