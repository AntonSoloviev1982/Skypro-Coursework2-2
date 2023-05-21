package com.example.skyprocoursework22.service.impl;

import com.example.skyprocoursework22.exception.QuestionNotFoundException;
import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int questionIndex = random.nextInt(5);
        List<Question> questionsWithIndex = new ArrayList<>(questions);
        return questionsWithIndex.get(questionIndex);
    }
}
