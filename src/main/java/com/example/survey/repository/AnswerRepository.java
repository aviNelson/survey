package com.example.survey.repository;

import com.example.survey.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {
}
