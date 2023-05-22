package com.example.skyprocoursework22.service.impl;


import com.example.skyprocoursework22.exception.QuestionIllegalArgumentException;
import com.example.skyprocoursework22.model.Question;
import com.example.skyprocoursework22.service.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private Set<Question> questions;

    @BeforeEach
    public void beforeEach() {
        questions = Set.of(
                new Question("Вопрос 1", "Ответ 1"),
                new Question("Вопрос 2", "Ответ 2"),
                new Question("Вопрос 3", "Ответ 3")
        );

        Mockito.when(questionService.getAll()).thenReturn(questions);
    }

//    public static Stream<Arguments> getQuestionsTestParams() {
//        return Stream.of(
//                Arguments.of(new Question("Вопрос 1", "Ответ 1")),
//                Arguments.of(new Question("Вопрос 2", "Ответ 2")),
//                Arguments.of(new Question("Вопрос 3", "Ответ 3"))
//        );
//    }

    @Test
    public void getQuestionsTest(Question expected) {

    }

    @Test
    public void getQuestionsWhenAmountMoreThenSetQuestionsSizeTest() {


    }



}
