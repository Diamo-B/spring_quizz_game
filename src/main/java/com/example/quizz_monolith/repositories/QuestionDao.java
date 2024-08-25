package com.example.quizz_monolith.repositories;

import com.example.quizz_monolith.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    public List<Question> findByCategory(String category);
}
