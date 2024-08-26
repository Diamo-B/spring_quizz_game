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

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try{
            return new ResponseEntity<>(dao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<?> addQuestion(Question question){
        try {
           return new ResponseEntity<>(dao.save(question), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error!! can't create a new question", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<String> deleteQuestion(Long questionId) {
        try {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error!! can't delete this question", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
