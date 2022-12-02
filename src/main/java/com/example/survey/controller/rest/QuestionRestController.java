package com.example.survey.controller.rest;

import com.example.survey.dto.CreateEditDto.QuestionCreateEditDto;
import com.example.survey.dto.ReadDto.QuestionReadDto;
import com.example.survey.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/surveys/{surveyId}")
public class QuestionRestController {
    private final QuestionService questionService;

    @GetMapping("/questions")
    public List<QuestionReadDto> findBySurveyId(@PathVariable("surveyId") Integer surveyId) {
        return questionService.findBySurveyId(surveyId);
    }

    @GetMapping("/questions/{id}")
    public QuestionReadDto findBySurveyIdAndId(@PathVariable("surveyId") Integer surveyId,
                                               @PathVariable("id") Integer id) {
        return questionService.findBySurveyIdAndId(surveyId, id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionReadDto create(@PathVariable("surveyId") Integer surveyId,
                                  @RequestBody QuestionCreateEditDto questionCreateEditDto) {
        return questionService.create(surveyId, questionCreateEditDto);
    }

    @PutMapping("/questions/{id}")
    public QuestionReadDto update(@PathVariable("surveyId") Integer surveyId,
                                  @PathVariable("id") Integer id,
                                  @RequestBody QuestionCreateEditDto questionCreateEditDto) {
        return questionService.update(id, questionCreateEditDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/questions/{id}")
    public void delete(@PathVariable("surveyId") Integer surveyId,
                       @PathVariable("id") Integer id) {
        if (!questionService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
