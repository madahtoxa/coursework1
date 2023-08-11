package contoller;
import model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.QuestionService;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/add")
    public Question add(@RequestParam(name = "question") String question,
                        @RequestParam(name = "answer")String answer){
        return questionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question remove(@RequestParam(name = "question") String question,
                           @RequestParam(name = "answer")String answer){
        return questionService.remove(new Question(question,answer));
    }
    @GetMapping
    public Collection<Question> getAll(){
        return questionService.getAll();
    }
}