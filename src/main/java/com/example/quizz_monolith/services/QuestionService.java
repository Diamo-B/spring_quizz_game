package com.example.quizz_monolith.services;

import com.example.quizz_monolith.models.Question;
import com.example.quizz_monolith.repositories.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    public QuestionDao dao;

    @Autowired
    public QuestionService(QuestionDao dao) {
        this.dao = dao;
    }

    public ResponseEntity<List<Question>> getAll() {
        try{
            return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public List<Question> getByCategory(String category) {
        return dao.findByCategory(category);
    }

    public Question addQuestion(Question question){
        return dao.save(question);
    }

    public void deleteQuestion(Long questionId) {
        dao.deleteById(questionId);
    }
}
