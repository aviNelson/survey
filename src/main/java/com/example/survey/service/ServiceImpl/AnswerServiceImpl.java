package com.example.survey.service.ServiceImpl;

import com.example.survey.dto.CreateEditDto.AnswerCreateDto;
import com.example.survey.dto.ReadDto.AnswerReadDto;
import com.example.survey.entity.Question;
import com.example.survey.entity.Survey;
import com.example.survey.entity.User;
import com.example.survey.exeption.NoSuchEntityException;
import com.example.survey.mapper.AnswerMapper;
import com.example.survey.repository.AnswerRepository;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.repository.SurveyRepository;
import com.example.survey.repository.UserRepository;
import com.example.survey.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    @Override
    public List<AnswerReadDto> findAll() {
        return null;
    }

    @Override
    public Optional<AnswerReadDto> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<AnswerReadDto> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public AnswerReadDto create(Integer questionId, Integer surveyId, String username, AnswerCreateDto answerCreateDto) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Optional<Survey> optionalSurvey = surveyRepository.findById(surveyId);
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalQuestion.isPresent()&&optionalUser.isPresent()&&optionalSurvey.isPresent()){
            return Optional.of(answerCreateDto)
                    .map(AnswerMapper.INSTANCE::toEntity)
                    .map(entity->{
                        entity.setSurvey(optionalSurvey.get());
                        entity.setQuestion(optionalQuestion.get());
                        optionalUser.get().addAnswers(entity);
                        return entity;
                    })
                    .map(answerRepository::save)
                    .map(AnswerMapper.INSTANCE::toDTO)
                    .orElseThrow();
        }
        else throw new NoSuchEntityException("Not found entity");
    }


}

