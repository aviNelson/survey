package com.example.survey.service;

import com.example.survey.dto.CreateEditDto.SurveyCreateEditDto;
import com.example.survey.dto.ReadDto.SurveyReadDto;

import java.util.List;
import java.util.Optional;

public interface SurveyService {
    public List<SurveyReadDto> findAll();

    public List<SurveyReadDto> findAllAnswered();

    public List<SurveyReadDto> findActive();

    public Optional<SurveyReadDto> findById(Integer id);

    public Optional<SurveyReadDto> findActiveById(Integer id);

    public SurveyReadDto create(SurveyCreateEditDto surveyCreateEditDto);

    public Optional<SurveyReadDto> update(Integer id, SurveyCreateEditDto surveyCreateEditDto);

    public boolean delete(Integer id);
}
