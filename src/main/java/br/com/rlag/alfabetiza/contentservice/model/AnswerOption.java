package br.com.rlag.alfabetiza.contentservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "answer_options")
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String imageUrl;  // Imagem descritiva da resposta

    private boolean isCorrect;  // Indica se é a resposta correta

    @ManyToOne
    @JoinColumn(name = "practice_id")
    private Practice practice;  // Referência à prática pai
}