package com.example.survey.controller.rest;

import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.UserReadDto;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserRestController {
    private final UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserReadDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable("id") Integer id) {
        return userService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@RequestBody @Validated UserCreateEditDto userCreateEditDto) {
        return userService.create(userCreateEditDto);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Integer id, @RequestBody @Validated UserCreateEditDto userCreateEditDto) {
        return userService.update(id, userCreateEditDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}






















