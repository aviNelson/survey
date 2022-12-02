package com.example.survey.mapper;


import com.example.survey.dto.CreateEditDto.AnsweredQuestionCreateEditDto;
import com.example.survey.dto.ReadDto.AnsweredQuestionReadDto;
import com.example.survey.entity.AnsweredQuestion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface AnsweredQuestionMapper {
    AnsweredQuestionMapper INSTANCE = Mappers.getMapper(AnsweredQuestionMapper.class);

    @Mapping(target = "userId",source = "user.id")
    @Mapping(target = "questionId",source = "question.id")
    AnsweredQuestionReadDto toDTO(AnsweredQuestion answeredQuestion);

    @Mapping(target = "user.id",source = "userId")
    AnsweredQuestion toEntity(AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto);

    AnsweredQuestion updateAnswer(AnsweredQuestionCreateEditDto dto, @MappingTarget AnsweredQuestion entity);
}
