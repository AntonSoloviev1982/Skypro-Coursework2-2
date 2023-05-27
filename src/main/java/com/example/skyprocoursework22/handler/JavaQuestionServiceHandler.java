package com.example.skyprocoursework22.handler;

import com.example.skyprocoursework22.exception.QuestionNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class JavaQuestionServiceHandler {

    @ExceptionHandler(QuestionNotFoundException.class)
    public String removeWhenQuestionNotFoundException() {
        return "Вопрос не был найден";
    }

}
