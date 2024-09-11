package br.com.rlag.alfabetiza.contentservice.controller;

import br.com.rlag.alfabetiza.contentservice.model.Lesson;
import br.com.rlag.alfabetiza.contentservice.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    // Obter todas as aulas
    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonService.getAllLessons();
        return ResponseEntity.ok(lessons);
    }

    // Obter uma aula por ID
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Lesson lesson = lessonService.getLessonById(id);
        if (lesson != null) {
            return ResponseEntity.ok(lesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova aula
    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson newLesson = lessonService.saveLesson(lesson);
        return ResponseEntity.ok(newLesson);
    }

    // Atualizar uma aula existente
    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson lessonDetails) {
        Lesson updatedLesson = lessonService.updateLesson(id, lessonDetails);
        if (updatedLesson != null) {
            return ResponseEntity.ok(updatedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma aula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        boolean isDeleted = lessonService.deleteLesson(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}