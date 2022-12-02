package com.example.survey.entity;

import com.example.survey.enums.QuestionType;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_text")
    private String questionText;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<AnswerVariant> answerVariants= new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<AnsweredQuestion> answeredQuestions = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionText, question.questionText) && questionType == question.questionType && Objects.equals(survey, question.survey);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", questionType=" + questionType +
                ", survey" + survey +
                '}';
    }
}
