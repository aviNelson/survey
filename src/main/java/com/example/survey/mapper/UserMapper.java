package com.example.survey.mapper;

import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.UserReadDto;
import com.example.survey.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,unmappedSourcePolicy = ReportingPolicy.WARN,componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserReadDto toDTO(User user);

    User toEntity(UserCreateEditDto userReadDto);

    User updateUser(UserCreateEditDto dto,@MappingTarget User entity);


}
