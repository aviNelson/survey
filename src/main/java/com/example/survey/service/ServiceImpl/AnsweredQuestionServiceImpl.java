package com.example.survey.service.ServiceImpl;


import com.example.survey.dto.CreateEditDto.AnsweredQuestionCreateEditDto;
import com.example.survey.dto.ReadDto.AnsweredQuestionReadDto;
import com.example.survey.entity.Answer;
import com.example.survey.entity.Question;
import com.example.survey.exeption.NoSuchEntityException;
import com.example.survey.mapper.AnswerMapper;
import com.example.survey.mapper.AnsweredQuestionMapper;
import com.example.survey.repository.AnsweredQuestionRepository;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.service.AnsweredQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnsweredQuestionServiceImpl implements AnsweredQuestionService {

    private final AnsweredQuestionRepository answeredQuestionRepository;
    private final AnsweredQuestionMapper answeredQuestionMapper;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;

    @Override
    @Transactional
    public List<AnsweredQuestionReadDto> findAll() {
        return answeredQuestionRepository.findAll().stream()
                .map(AnsweredQuestionMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AnsweredQuestionReadDto create(Integer questionId, AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto) {
        List<Answer> answers = answeredQuestionCreateEditDto.getAnswers();

        Optional<Question> maybeQuestion = questionRepository.findById(questionId);
        if (maybeQuestion.isPresent()) {
            return Optional.of(answeredQuestionCreateEditDto)
                    .map(AnsweredQuestionMapper.INSTANCE::toEntity)
                    .map(entity -> {
                                entity.setQuestion(maybeQuestion.get());
                                entity.addAnswers(answers);
                                return entity;
                            }
                    )
                    .map(answeredQuestionRepository::save)
                    .map(AnsweredQuestionMapper.INSTANCE::toDTO)
                    .orElseThrow();
        } else throw new NoSuchEntityException(
                String.format("No such question with ID=%s in database", questionId)
        );
    }

    @Override
    public Optional<AnsweredQuestionReadDto> update(Integer id, AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto) {
        return answeredQuestionRepository.findById(id)
                .map(entity -> answeredQuestionMapper.updateAnswer(answeredQuestionCreateEditDto, entity))
                .map(answeredQuestionRepository::saveAndFlush)
                .map(AnsweredQuestionMapper.INSTANCE::toDTO);
    }

}
