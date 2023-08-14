package com.example.coursework.service;

import com.example.coursework.model.Question;

import java.util.Collection;


public interface QuestionService {
    Question add(String question, String answer);

    Question remove(Question question);

    Question add(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}