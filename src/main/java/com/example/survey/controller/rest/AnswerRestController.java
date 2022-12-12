package com.example.survey.controller.rest;


import com.example.survey.dto.CreateEditDto.AnswerCreateDto;
import com.example.survey.dto.ReadDto.AnswerReadDto;
import com.example.survey.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AnswerRestController {
    private final AnswerService answerService;

    @PostMapping("surveys/{surveyId}/questions/{questionId}/answers")
    public AnswerReadDto create(
            @PathVariable("questionId") Integer questionId,
            @PathVariable ("surveyId") Integer surveyId,
            Principal principal,
            @RequestBody AnswerCreateDto answerCreateDto){
        return answerService.create(questionId, questionId,principal.getName(),answerCreateDto);
    }
}
