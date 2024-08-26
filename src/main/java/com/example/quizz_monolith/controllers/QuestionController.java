package com.example.quizz_monolith.controllers;
import com.example.quizz_monolith.services.QuestionService;
import com.example.quizz_monolith.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions/")
public class QuestionController {

    public QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAll();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category){
        return service.getByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }

    @DeleteMapping("/{questionId}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long questionId){
        return service.deleteQuestion(questionId);
    }
}
