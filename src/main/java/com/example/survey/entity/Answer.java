package com.example.survey.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answered_question_id")
    @JsonIgnore
    private AnsweredQuestion answeredQuestion;

    @Override
    public String toString() {
        return "Answer{" +
                "content='" + content + '\'' +
                '}';
    }
}
