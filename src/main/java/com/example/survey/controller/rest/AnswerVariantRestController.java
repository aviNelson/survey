package com.example.survey.controller.rest;

import com.example.survey.dto.CreateEditDto.AnswerVariantCreateEditDto;
import com.example.survey.dto.ReadDto.AnswerVariantReadDto;
import com.example.survey.service.AnswerVariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/surveys/{surveyId}/questions/{questionId}")
public class AnswerVariantRestController {
    private final AnswerVariantService answerVariantService;

    @GetMapping("/answer_variants")
    public List<AnswerVariantReadDto> findAllByQuestionId(@PathVariable("surveyId") Integer surveyId,
                                                          @PathVariable("questionId") Integer questionId) {
        return answerVariantService.findByQuestionId(questionId);
    }

    @PostMapping("/answer_variants")
    public AnswerVariantReadDto create(@PathVariable("surveyId") Integer surveyId,
                                       @PathVariable("questionId") Integer questionId,
                                       @RequestBody AnswerVariantCreateEditDto answerVariantCreateEditDto) {
        return answerVariantService.create(questionId, answerVariantCreateEditDto);
    }

    @PutMapping("/answer_variants/{id}")
    public AnswerVariantReadDto update(@PathVariable("surveyId") Integer surveyId,
                                       @PathVariable("questionId") Integer questionId,
                                       @PathVariable("id") Integer id,
                                       @RequestBody AnswerVariantCreateEditDto answerVariantCreateEditDto) {
        return answerVariantService.update(id, answerVariantCreateEditDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("answer_variants/{id}")
    public void delete(@PathVariable("surveyId") Integer surveyId,
                       @PathVariable("questionId") Integer questionId,
                       @PathVariable("id") Integer id) {
        if (!answerVariantService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
