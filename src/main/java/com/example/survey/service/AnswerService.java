package com.example.survey.service;

import com.example.survey.dto.CreateEditDto.AnswerCreateDto;
import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerReadDto;
import com.example.survey.dto.ReadDto.UserReadDto;
import com.example.survey.entity.Question;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    public List<AnswerReadDto> findAll();

    public Optional<AnswerReadDto> findById(Integer id);

    public Optional<AnswerReadDto> findByUsername(String username);

    public AnswerReadDto create(Integer questionId,Integer surveyId,String username, AnswerCreateDto answerCreateDto);
}
