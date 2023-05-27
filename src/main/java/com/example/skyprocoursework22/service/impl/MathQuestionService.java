package com.example.skyprocoursework22.service.impl;

import com.example.skyprocoursework22.exception.QuestionNotFoundException;
import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.repository.QuestionRepository;
import com.example.skyprocoursework22.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final QuestionRepository repository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        return repository.add(question, answer);
    }

    @Override
    public Question remove(Question question) {
        if (!repository.getAll().contains(question)) {
            throw new QuestionNotFoundException();
        }
        repository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return repository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int questionIndex = random.nextInt(repository.getAll().size());
        List<Question> questionsWithIndex = new ArrayList<>(repository.getAll());
        return questionsWithIndex.get(questionIndex);
    }
}
