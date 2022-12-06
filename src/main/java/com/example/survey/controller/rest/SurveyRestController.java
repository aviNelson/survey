package com.example.survey.controller.rest;

import com.example.survey.dto.CreateEditDto.SurveyCreateEditDto;
import com.example.survey.dto.ReadDto.SurveyReadDto;
import com.example.survey.jsonview.View;
import com.example.survey.service.SurveyService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/surveys")
public class SurveyRestController {
    private final SurveyService surveyService;
    @JsonView(View.NoAnswered.class)
    @GetMapping
    public List<SurveyReadDto> findAll() {
        return surveyService.findAll();
    }

    @GetMapping("/answered")
    public List<SurveyReadDto> findAllAnswered() {
        return surveyService.findAllAnswered();
    }

    @JsonView(View.NoAnswered.class)
    @GetMapping("/{id}")
    public SurveyReadDto findById(@PathVariable("id") Integer id) {
        return surveyService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @JsonView(View.NoAnswered.class)
    @GetMapping("/active")
    public List<SurveyReadDto> findActive() {
        return surveyService.findActive();
    }

    @JsonView(View.NoAnswered.class)
    @GetMapping("/active/{id}")
    public SurveyReadDto findActiveById(@PathVariable("id") Integer id) {
        return surveyService.findActiveById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @JsonView(View.NoAnswered.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SurveyReadDto create(@RequestBody @Validated SurveyCreateEditDto surveyCreateEditDto) {
        return surveyService.create(surveyCreateEditDto);
    }

    @JsonView(View.NoAnswered.class)
    @PutMapping("/{id}")
    public SurveyReadDto update(@PathVariable("id") Integer id, @RequestBody @Validated SurveyCreateEditDto surveyCreateEditDto) {
        return surveyService.update(id, surveyCreateEditDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        if (!surveyService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
