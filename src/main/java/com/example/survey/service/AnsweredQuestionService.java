package com.example.survey.service;


import com.example.survey.dto.CreateEditDto.AnsweredQuestionCreateEditDto;
import com.example.survey.dto.ReadDto.AnsweredQuestionReadDto;

import java.util.List;
import java.util.Optional;

public interface AnsweredQuestionService {
    public List<AnsweredQuestionReadDto> findAll();

    public AnsweredQuestionReadDto create(Integer questionId, AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto);

    public Optional<AnsweredQuestionReadDto> update(Integer id, AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto);


}
