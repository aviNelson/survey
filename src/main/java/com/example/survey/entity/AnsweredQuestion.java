package com.example.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "answered_question")
public class AnsweredQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Builder.Default
    @OneToMany(mappedBy = "answeredQuestion", cascade = CascadeType.ALL)
    private List<Answer> answers = new ArrayList<>();

    public void addAnswers(List<Answer> answers) {
        for (Answer answer : answers) {
            answer.setAnsweredQuestion(this);

        }
    }

    @Override
    public String toString() {
        return "AnsweredQuestion{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                '}';
    }
}
