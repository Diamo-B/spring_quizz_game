package com.example.quizz_monolith.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String category;
    private String difficulty;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;
}
