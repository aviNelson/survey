package com.example.survey.exeption;

public class NoSuchEntityException extends RuntimeException{
    public NoSuchEntityException(String message) {
        super(message);
    }
}
