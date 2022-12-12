--liquibase formatted sql

--changeset avi_nelson:1
CREATE TABLE IF NOT EXISTS users
(
    id        SERIAL PRIMARY KEY,
    email VARCHAR(128) NOT NULL UNIQUE,
    password  VARCHAR(128) NOT NULL,
    roles VARCHAR(64) DEFAULT 'USER'
    );

--changeset avi_nelson:2
CREATE TABLE IF NOT EXISTS survey
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    start_date  TIMESTAMP    NOT NULL,
    end_date    TIMESTAMP,
    description VARCHAR(256) NOT NULL
    );

--changeset avi_nelson:3
CREATE TABLE IF NOT EXISTS question
(
    id            SERIAL PRIMARY KEY,
    question_text VARCHAR(256),
    survey_id INT REFERENCES survey(id),
    question_type VARCHAR(64)
    );