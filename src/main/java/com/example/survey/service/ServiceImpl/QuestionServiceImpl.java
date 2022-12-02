package com.example.survey.service.ServiceImpl;

import com.example.survey.dto.CreateEditDto.QuestionCreateEditDto;
import com.example.survey.dto.ReadDto.QuestionReadDto;
import com.example.survey.entity.Survey;
import com.example.survey.exeption.NoSuchEntityException;
import com.example.survey.mapper.QuestionMapper;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;
    private final SurveyRepository surveyRepository;


    @Override
    public List<QuestionReadDto> findBySurveyId(Integer surveyId) {
        return questionRepository.findBySurveyId(surveyId).stream()
                .map(QuestionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionReadDto> findBySurveyIdAndId(Integer surveyId, Integer id) {
        return questionRepository.findBySurveyIdAndId(surveyId, id)
                .map(QuestionMapper.INSTANCE::toDTO);
    }

    @Override
    @Transactional
    public QuestionReadDto create(Integer surveyId, QuestionCreateEditDto questionCreateEditDto) {
        Optional<Survey> maybeSurvey = surveyRepository.findById(surveyId);
        if (maybeSurvey.isPresent()) {
            return Optional.of(questionCreateEditDto)
                    .map(QuestionMapper.INSTANCE::toEntity)
                    .map(entity -> {
                                entity.setSurvey(maybeSurvey.get());
                                return entity;
                            }
                    )
                    .map(questionRepository::save)
                    .map(QuestionMapper.INSTANCE::toDTO)
                    .orElseThrow();
        } else throw new NoSuchEntityException(
                String.format("No such poll with ID=%s in database", surveyId)
        );
    }

    @Override
    @Transactional
    public Optional<QuestionReadDto> update(Integer id, QuestionCreateEditDto questionCreateEditDto) {
        return questionRepository.findById(id)
                .map(entity->questionMapper.updateQuestion(questionCreateEditDto,entity))
                .map(questionRepository::saveAndFlush)
                .map(QuestionMapper.INSTANCE::toDTO);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return questionRepository.findById(id)
                .map(entity->{
                    questionRepository.delete(entity);
                    questionRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
