package com.example.survey.repository;

import com.example.survey.entity.Survey;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM survey s WHERE s.end_date>localtimestamp")
    public List<Survey> findActive();

    @Query(nativeQuery = true, value = "SELECT * FROM survey s WHERE s.end_date>localtimestamp AND id=?1")
    public Optional<Survey> findActiveById(Integer id);

    @EntityGraph(attributePaths = {"questions"})
    @Query(value = "select s from Survey as s")
    public List<Survey> findAllBy();

//    @EntityGraph(attributePaths = {"questions"})
//    @Query(nativeQuery = true,value = "SELECT s.* FROM survey s left join answered_question aq on s.id = aq.survey_id left join users u on aq.user_id = u.id WHERE u.email=?1")
//    public List<Survey> findAllByUsername(String username);
}
