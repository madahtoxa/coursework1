package service;

import model.Question;
import org.springframework.stereotype.Service;
import Exception.NotEnoughQuestionException;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionException();
        }
        return Stream.generate(questionService::getRandomQuestion)
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }
}