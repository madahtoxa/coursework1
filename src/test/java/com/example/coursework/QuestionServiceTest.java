package com.example.coursework;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.QuestionServiceImpl;
import service.QuestionService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


public class QuestionServiceTest {
    QuestionServiceImpl  service = new QuestionServiceImpl ();

    @Test
    void add() {
        service.add(new Question("How are you?","Good"));
        service.add(new Question("Are you beautiful","Yes, of course"));
        service.add(new Question("Do you love me?","No"));
        Collection<Question> actual = service.getAll();
        assertEquals(3, actual.size());
        assertTrue(actual.contains(new Question("How are you?","Good")));
        assertTrue(actual.contains(new Question("Are you beautiful","Yes, of course")));
        assertTrue(actual.contains(new Question("Do you love me?","No")));
    }

    @Test
    void remove() {
        Question q1 = service.add(new Question("How are you?","Good"));
        Question q2 = service.add(new Question("Are you beautiful","Yes, of course"));
        Question q3 = service.add(new Question("Do you love me?","No"));
        Collection<Question> actual = service.getAll();
        service.remove(q1);
        service.remove(q2);
        service.remove(q3);
        assertEquals(3, actual.size());
        assertFalse(actual.contains(q1));
        assertTrue(actual.contains(q2));
        assertTrue(actual.contains(q3));
    }
}