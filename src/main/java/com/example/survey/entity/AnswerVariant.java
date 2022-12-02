package com.example.survey.entity;

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
@Table(name = "answer_variant")
public class AnswerVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerVariant that = (AnswerVariant) o;
        return Objects.equals(content, that.content) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "AnswerVariant{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", question=" + question +
                '}';
    }
}
