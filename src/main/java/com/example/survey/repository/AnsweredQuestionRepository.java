package com.example.survey.repository;


import com.example.survey.entity.AnsweredQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnsweredQuestionRepository extends JpaRepository<AnsweredQuestion, Integer> {
}
