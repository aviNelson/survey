package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.SurveyCreateEditDto;
import com.example.survey.dto.ReadDto.SurveyReadDto;
import com.example.survey.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface SurveyMapper {
    SurveyMapper INSTANCE = Mappers.getMapper(SurveyMapper.class);

    SurveyReadDto toDTO(Survey survey);

    Survey toEntity(SurveyCreateEditDto surveyCreateEditDto);

    Survey updateSurvey(SurveyCreateEditDto dto,@MappingTarget Survey entity);
}
