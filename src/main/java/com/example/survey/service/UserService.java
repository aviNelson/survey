package com.example.survey.service;

import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.UserReadDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<UserReadDto> findAll();

    public Optional<UserReadDto> findById(Integer id);

    public Optional<UserReadDto> findByUsername(String username);

    public UserReadDto create(UserCreateEditDto user);

    public Optional<UserReadDto> update(String username, UserCreateEditDto user);

    public boolean delete(Integer id);
}
