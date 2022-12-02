package com.example.survey.controller.rest;


import com.example.survey.dto.CreateEditDto.AnsweredQuestionCreateEditDto;
import com.example.survey.dto.ReadDto.AnsweredQuestionReadDto;
import com.example.survey.service.AnsweredQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AnsweredQuestionRestController {

    private  final AnsweredQuestionService answeredQuestionService;

    @GetMapping("/answered_questions")
    public List<AnsweredQuestionReadDto> findAll(){
        return answeredQuestionService.findAll();
    }

    @PostMapping("surveys/{surveyId}/questions/{questionId}/answers")
    public AnsweredQuestionReadDto create(
                                          @PathVariable("questionId") Integer questionId,
                                          @RequestBody AnsweredQuestionCreateEditDto answeredQuestionCreateEditDto){
        return answeredQuestionService.create(questionId, answeredQuestionCreateEditDto);
    }
}
