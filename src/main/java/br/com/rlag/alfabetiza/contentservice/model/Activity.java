package br.com.rlag.alfabetiza.contentservice.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> objectives;

    private String presentationVideoUrl;
    private String instructionVideoUrl;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Practice> practices;  // Lista de práticas associadas

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
