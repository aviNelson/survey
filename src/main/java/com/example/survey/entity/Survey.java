package com.example.survey.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "start_date")
    private  LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "survey",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Question> questions=new ArrayList<>();

    @OneToMany(mappedBy = "survey",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Answer> answers=new ArrayList<>();

    public void addQuestion(Question question){
        questions.add(question);
        question.setSurvey(this);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(name, survey.name) && Objects.equals(startDate, survey.startDate) && Objects.equals(description, survey.description);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
