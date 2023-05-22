package com.example.skyprocoursework22.repository;

import com.example.skyprocoursework22.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    public Question add(String question, String answer);

    public Question remove(Question question);

    public Collection<Question> getAll();

}
