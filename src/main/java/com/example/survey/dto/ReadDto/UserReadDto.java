package com.example.survey.dto.ReadDto;

import com.example.survey.enums.Role;
import lombok.Value;

@Value
public class UserReadDto {
    Integer id;
    String username;
    Role role;
}
