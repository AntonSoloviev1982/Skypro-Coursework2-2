package com.example.skyprocoursework22.service.impl;

import com.example.skyprocoursework22.exception.QuestionNotFoundException;
import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.repository.QuestionRepository;
import com.example.skyprocoursework22.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class JavaQuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @InjectMocks
    private QuestionService questionService;

    @BeforeEach
    public void beforeEach() {
        questionService.add("Вопрос 1", "Ответ 1");
        questionService.add("Вопрос 2", "Ответ 2");
        questionService.add("Вопрос 3", "Ответ 3");
    }

    @AfterEach
    public void afterEach() {
        questionService.getAll().stream()
                .map(e -> questionService.remove(e));
    }

    @Test
    public void addTest() {
        int beforeCount = questionService.getAll().size();
        Question expected = new Question("Вопрос 4", "Ответ 4");
        Assertions.assertThat(questionService.add("Вопрос 4", "Ответ 4")).isEqualTo(expected)
                .isIn(questionService.getAll());
        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount + 1);

    }

    @Test
    public void removeTest() {
        int beforeCount = questionService.getAll().size();
        Question expected = new Question("Вопрос 1", "Ответ 1");
        Assertions.assertThat(questionService.remove(new Question("Вопрос 1", "Ответ 1"))).isEqualTo(expected)
                .isNotIn(questionService.getAll());
        Assertions.assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void removeWhenNotFoundTest() {
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("Вопрос 4", "Ответ 4")));
    }

    @Test
    public void getAllTest() {
        Assertions.assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Вопрос 1", "Ответ 1"),
                        new Question("Вопрос 2", "Ответ 2"),
                        new Question("Вопрос 3", "Ответ 3")
                );
    }

}
