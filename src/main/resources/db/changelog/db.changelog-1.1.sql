--liquibase formatted sql

--changeset avi_nelson:1
CREATE TABLE IF NOT EXISTS answer
(
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id) NOT NULL ,
    question_id INT REFERENCES question(id) NOT NULL,
    survey_id INT REFERENCES survey(id) NOT NULL,
    content VARCHAR(512)
    );

--changeset avi_nelson:2
CREATE TABLE IF NOT EXISTS answer_variant
(
    id
    SERIAL
    PRIMARY
    KEY,
    content
    VARCHAR
(
    512
) NOT NULL,
    question_id INT REFERENCES question
(
    id
)
    );