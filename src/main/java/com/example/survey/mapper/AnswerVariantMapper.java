package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.AnswerVariantCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerVariantReadDto;
import com.example.survey.entity.AnswerVariant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface AnswerVariantMapper {
    AnswerVariantMapper INSTANCE = Mappers.getMapper(AnswerVariantMapper.class);

    @Mapping(target = "questionId",source = "question.id")
    AnswerVariantReadDto toDTO(AnswerVariant answerVariant);

    AnswerVariant toEntity(AnswerVariantCreateEditDto answerVariantCreateEditDto);

    AnswerVariant updateAnswerVariant(AnswerVariantCreateEditDto dto,@MappingTarget AnswerVariant entity);
}
