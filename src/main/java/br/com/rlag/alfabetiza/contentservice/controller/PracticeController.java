package br.com.rlag.alfabetiza.contentservice.controller;

import br.com.rlag.alfabetiza.contentservice.model.Practice;
import br.com.rlag.alfabetiza.contentservice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practices")
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    // Obter todas as práticas
    @GetMapping
    public ResponseEntity<List<Practice>> getAllPractices() {
        List<Practice> practices = practiceService.getAllPractices();
        return ResponseEntity.ok(practices);
    }

    // Obter uma prática por ID
    @GetMapping("/{id}")
    public ResponseEntity<Practice> getPracticeById(@PathVariable Long id) {
        Practice practice = practiceService.getPracticeById(id);
        if (practice != null) {
            return ResponseEntity.ok(practice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova prática
    @PostMapping
    public ResponseEntity<Practice> createPractice(@RequestBody Practice practice) {
        Practice newPractice = practiceService.savePractice(practice);
        return ResponseEntity.ok(newPractice);
    }

    // Atualizar uma prática existente
    @PutMapping("/{id}")
    public ResponseEntity<Practice> updatePractice(@PathVariable Long id, @RequestBody Practice practiceDetails) {
        Practice updatedPractice = practiceService.updatePractice(id, practiceDetails);
        if (updatedPractice != null) {
            return ResponseEntity.ok(updatedPractice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma prática
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePractice(@PathVariable Long id) {
        boolean isDeleted = practiceService.deletePractice(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
