package com.example.survey.controller.rest;

import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.UserReadDto;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthRegistRestController {
    private final UserService userService;


    @PostMapping("/registration")
    public UserReadDto create(@RequestBody @Validated UserCreateEditDto userCreateEditDto) {
        return userService.create(userCreateEditDto);
    }
}
