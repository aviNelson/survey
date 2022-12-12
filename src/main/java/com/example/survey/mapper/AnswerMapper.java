package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.AnswerCreateDto;
import com.example.survey.dto.CreateEditDto.AnswerVariantCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerReadDto;
import com.example.survey.dto.ReadDto.AnswerVariantReadDto;
import com.example.survey.entity.Answer;
import com.example.survey.entity.AnswerVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerReadDto toDTO(Answer answer);

    Answer toEntity(AnswerCreateDto answerCreateDto);
}
