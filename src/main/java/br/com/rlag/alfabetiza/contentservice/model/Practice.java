package br.com.rlag.alfabetiza.contentservice.model;


import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "practices")
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String imageUrl;  // Imagem descritiva da prática

    @OneToMany(mappedBy = "practice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answerOptions;  // Lista de respostas possíveis

    private Long correctAnswerId;  // Referência para a resposta correta
}
