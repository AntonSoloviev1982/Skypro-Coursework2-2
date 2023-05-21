package com.example.skyprocoursework22.service.impl;

import com.example.skyprocoursework22.exception.QuestionIllegalArgumentException;
import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.service.ExaminerService;
import com.example.skyprocoursework22.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new QuestionIllegalArgumentException();
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
