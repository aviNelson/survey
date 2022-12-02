package com.example.survey.service;

import com.example.survey.dto.CreateEditDto.AnswerVariantCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerVariantReadDto;

import java.util.List;
import java.util.Optional;

public interface AnswerVariantService {
    public List<AnswerVariantReadDto> findByQuestionId(Integer questionId);

//    public Optional<AnswerVariantReadDto> findById(Integer id);

    public AnswerVariantReadDto create(Integer questionId, AnswerVariantCreateEditDto answerVariantCreateEditDto);

    public Optional<AnswerVariantReadDto> update(Integer id, AnswerVariantCreateEditDto answerVariantCreateEditDto);

    public boolean delete(Integer id);
}
