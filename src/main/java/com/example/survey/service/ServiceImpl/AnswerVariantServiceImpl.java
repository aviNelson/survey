package com.example.survey.service.ServiceImpl;

import com.example.survey.dto.CreateEditDto.AnswerVariantCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerVariantReadDto;
import com.example.survey.entity.Question;
import com.example.survey.exeption.NoSuchEntityException;
import com.example.survey.mapper.AnswerVariantMapper;
import com.example.survey.repository.AnswerVariantRepository;
import com.example.survey.repository.QuestionRepository;
import com.example.survey.service.AnswerVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnswerVariantServiceImpl implements AnswerVariantService {
    private  final AnswerVariantRepository answerVariantRepository;
    private  final AnswerVariantMapper answerVariantMapper;
    private  final QuestionRepository questionRepository;

    @Override
    public List<AnswerVariantReadDto> findByQuestionId(Integer questionId) {
        return answerVariantRepository.getAnswerVariantsByQuestionId(questionId)
                .stream()
                .map(AnswerVariantMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AnswerVariantReadDto create(Integer questionId, AnswerVariantCreateEditDto answerVariantCreateEditDto) {
        Optional<Question> maybeQuestion = questionRepository.findById(questionId);
        if (maybeQuestion.isPresent()){
            return Optional.of(answerVariantCreateEditDto)
                    .map(AnswerVariantMapper.INSTANCE::toEntity)
                    .map(entity->{
                        entity.setQuestion(maybeQuestion.get());
                        return entity;
                            }
                    )
                    .map(answerVariantRepository::save)
                    .map(AnswerVariantMapper.INSTANCE::toDTO)
                    .orElseThrow();
        }else throw new NoSuchEntityException(
          String.format("No such question with ID=%s in database", questionId)
        );
    }

    @Override
    @Transactional
    public Optional<AnswerVariantReadDto> update(Integer id, AnswerVariantCreateEditDto answerVariantCreateEditDto) {
        return answerVariantRepository.findById(id)
                .map(entity->answerVariantMapper.updateAnswerVariant(answerVariantCreateEditDto,entity))
                .map(answerVariantRepository::saveAndFlush)
                .map(AnswerVariantMapper.INSTANCE::toDTO);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return answerVariantRepository.findById(id)
                .map(entity->{
                    answerVariantRepository.delete(entity);
                    answerVariantRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
