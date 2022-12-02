package com.example.survey.service.ServiceImpl;

import com.example.survey.dto.CreateEditDto.UserCreateEditDto;
import com.example.survey.dto.ReadDto.UserReadDto;
import com.example.survey.mapper.UserMapper;
import com.example.survey.repository.UserRepository;
import com.example.survey.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private  final UserMapper userMapper;

    @Override
    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserReadDto> findById(Integer id) {
        return userRepository.findById(id)
                .map(UserMapper.INSTANCE::toDTO);
    }
    @Transactional
    @Override
    public UserReadDto create(UserCreateEditDto userCreateEditDto) {
        return Optional.of(userCreateEditDto)
                .map(UserMapper.INSTANCE::toEntity)
                .map(userRepository::save)
                .map(UserMapper.INSTANCE::toDTO)
                .orElseThrow();
    }
    @Transactional
    @Override
    public Optional<UserReadDto> update(Integer id, UserCreateEditDto userCreateEditDto) {
        return userRepository.findById(id)
                .map(entity-> userMapper.updateUser(userCreateEditDto,entity))
                .map(userRepository::saveAndFlush)
                .map(UserMapper.INSTANCE::toDTO);
    }
    @Transactional
    @Override
    public boolean delete(Integer id) {
        return userRepository.findById(id)
                .map(entity->{
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}



























