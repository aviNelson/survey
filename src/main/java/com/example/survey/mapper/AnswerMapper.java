package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.AnswerCreateDto;
import com.example.survey.dto.ReadDto.AnswerReadDto;
import com.example.survey.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface AnswerMapper {
    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);
    @Mapping(target = "answeredQuestion",source = "answeredQuestion.id")
    AnswerReadDto toDTO(Answer answer);

    Answer toEntity(AnswerCreateDto answerCreateDto);

    List<AnswerReadDto> listToDto(List<Answer> answers);

}
