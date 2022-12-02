package com.example.survey.repository;

import com.example.survey.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM question q WHERE q.survey_id=?1")
    public List<Question> findBySurveyId(Integer surveyId);

    public Optional<Question> findBySurveyIdAndId(Integer surveyId,Integer id);

    @Query(nativeQuery = true,value = "DELETE * FROM question q WHERE q.id=?1")
    void delete(Integer id);
}
