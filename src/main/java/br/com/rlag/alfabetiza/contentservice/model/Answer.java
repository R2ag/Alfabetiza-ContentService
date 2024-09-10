package br.com.rlag.alfabetiza.contentservice.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String description;
    private String imageUrl;  // Imagem descritiva da resposta

    @ManyToOne
    @JoinColumn(name = "practice_id")
    private Practice practice;  // Relacionamento com a prática
}
