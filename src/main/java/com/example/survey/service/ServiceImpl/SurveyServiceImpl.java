package com.example.survey.service.ServiceImpl;

import com.example.survey.dto.CreateEditDto.SurveyCreateEditDto;
import com.example.survey.dto.ReadDto.SurveyReadDto;
import com.example.survey.entity.Survey;
import com.example.survey.mapper.SurveyMapper;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {
    private final SurveyRepository surveyRepository;

    private final SurveyMapper surveyMapper;

    @Override
    public List<SurveyReadDto> findAll() {
        return surveyRepository.findAll().stream()
                .map(SurveyMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SurveyReadDto> findAllAnswered() {
        List<Survey> allBy = surveyRepository.findAllBy();
        return allBy.stream()
                .map(SurveyMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SurveyReadDto> findActive() {
        return surveyRepository.findActive().stream()
                .map(SurveyMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SurveyReadDto> findById(Integer id) {
        return surveyRepository.findById(id)
                .map(SurveyMapper.INSTANCE::toDTO);
    }

    @Override
    public Optional<SurveyReadDto> findActiveById(Integer id) {
        return surveyRepository.findActiveById(id)
                .map(SurveyMapper.INSTANCE::toDTO);
    }


    @Transactional
    @Override
    public SurveyReadDto create(SurveyCreateEditDto surveyCreateEditDto) {
        return Optional.of(surveyCreateEditDto)
                .map(SurveyMapper.INSTANCE::toEntity)
                .map(entity-> {
                    entity.setStartDate(LocalDateTime.now());
                    return entity;
                })
                .map(surveyRepository::save)
                .map(SurveyMapper.INSTANCE::toDTO)
                .orElseThrow();
    }

    @Transactional
    @Override
    public Optional<SurveyReadDto> update(Integer id, SurveyCreateEditDto surveyCreateEditDto) {
        return surveyRepository.findById(id)
                .map(entity->surveyMapper.updateSurvey(surveyCreateEditDto,entity))
                .map(surveyRepository::saveAndFlush)
                .map(SurveyMapper.INSTANCE::toDTO);
    }

    @Transactional
    @Override
    public boolean delete(Integer id) {
        return surveyRepository.findById(id)
                .map(entity->{
                    surveyRepository.delete(entity);
                    surveyRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
