package com.example.coursework;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import service.ExaminerServiceImpl;
import service.QuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    QuestionService questionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;

    private  List<Question> questions = List.of(
            new Question("How are you?","Good"),
            new Question("Are you beautiful","Yes, of course"),
            new Question("Do you love me?","No")
    );
    @Test
    void getQuestion(){
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion())
                .thenReturn(questions.get(2))
                .thenReturn(questions.get(0))
                .thenReturn(questions.get(1));
        ;

        Collection<Question> actual = examinerService.getQuestion(3);
        Assertions.assertEquals(3,actual.size());
        Assertions.assertTrue(questions.containsAll(actual));
    }
}