package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.QuestionCreateEditDto;
import com.example.survey.dto.ReadDto.QuestionReadDto;
import com.example.survey.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    @Mapping(target = "surveyId",source = "survey.id")
    QuestionReadDto toDTO(Question question);

    Question toEntity(QuestionCreateEditDto surveyCreateEditDto);

    Question updateQuestion(QuestionCreateEditDto dto,@MappingTarget Question entity);
}
