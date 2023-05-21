package com.example.skyprocoursework22.service;

import com.example.skyprocoursework22.model.Question;

import java.util.Collection;

public interface ExaminerService {

    public Collection<Question> getQuestions(int amount);

}
