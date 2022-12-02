package com.example.survey.dto.CreateEditDto;

import com.example.survey.enums.Role;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class UserCreateEditDto {
    @Email(message = "Invalid email")
    String username;

    @Size(min = 6,max = 20,message = "Password must be between 6 and 20 characters")
    String password;
}
