package com.example.survey.repository;

import com.example.survey.entity.AnswerVariant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerVariantRepository extends JpaRepository<AnswerVariant, Integer> {

    public List<AnswerVariant> getAnswerVariantsByQuestionId(Integer questionId);
}
