package com.example.skyprocoursework22.service;

import com.example.skyprocoursework22.model.Question;

import java.util.Collection;

public interface QuestionService {

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

    public Question getRandomQuestion();

}
