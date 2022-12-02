package com.example.survey.repository;

import com.example.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM survey s WHERE s.end_date>localtimestamp")
    public List<Survey> findActive();

    @Query(nativeQuery = true, value = "SELECT * FROM survey s WHERE s.end_date>localtimestamp AND id=?1")
    public Optional<Survey> findActiveById(Integer id);
}
