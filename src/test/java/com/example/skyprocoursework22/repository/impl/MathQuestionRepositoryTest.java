package com.example.skyprocoursework22.repository.impl;

import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.repository.QuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathQuestionRepositoryTest {

    private final QuestionRepository questionRepository = new MathQuestionRepository();


    @BeforeEach
    public void beforeEach() {
        questionRepository.add("Math вопрос 1", "Math ответ 1");
        questionRepository.add("Math вопрос 2", "Math ответ 2");
        questionRepository.add("Math вопрос 3", "Math ответ 3");
    }

    @AfterEach
    public void afterEach() {
        questionRepository.getAll().stream()
                .map(e -> questionRepository.remove(e));
    }

    @Test
    public void addTest() {
        int beforeCount = questionRepository.getAll().size();
        Question expected = new Question("Math вопрос 4", "Math ответ 4");
        Assertions.assertThat(questionRepository.add("Math вопрос 4", "Math ответ 4")).isEqualTo(expected)
                .isIn(questionRepository.getAll());
        Assertions.assertThat(questionRepository.getAll()).hasSize(beforeCount + 1);

    }

    @Test
    public void removeTest() {
        int beforeCount = questionRepository.getAll().size();
        Question expected = new Question("Math вопрос 1", "Math ответ 1");
        Assertions.assertThat(questionRepository.remove(new Question("Math вопрос 1", "Math ответ 1"))).isEqualTo(expected)
                .isNotIn(questionRepository.getAll());
        Assertions.assertThat(questionRepository.getAll()).hasSize(beforeCount - 1);
    }


    @Test
    public void getAllTest() {
        Assertions.assertThat(questionRepository.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Math вопрос 1", "Math ответ 1"),
                        new Question("Math вопрос 2", "Math ответ 2"),
                        new Question("Math вопрос 3", "Math ответ 3")
                );
    }
}
