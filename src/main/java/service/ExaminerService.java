package service;


import model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question>getQuestion(int amount);
}