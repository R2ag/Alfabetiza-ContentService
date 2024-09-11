package br.com.rlag.alfabetiza.contentservice.controller;

import br.com.rlag.alfabetiza.contentservice.model.AnswerOption;
import br.com.rlag.alfabetiza.contentservice.service.AnswerOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answer-options")
public class AnswerOptionController {

    @Autowired
    private AnswerOptionService answerOptionService;

    // Obter todas as opções de resposta
    @GetMapping
    public ResponseEntity<List<AnswerOption>> getAllAnswerOptions() {
        List<AnswerOption> answerOptions = answerOptionService.getAllAnswerOptions();
        return ResponseEntity.ok(answerOptions);
    }

    // Obter uma opção de resposta por ID
    @GetMapping("/{id}")
    public ResponseEntity<AnswerOption> getAnswerOptionById(@PathVariable Long id) {
        AnswerOption answerOption = answerOptionService.getAnswerOptionById(id);
        if (answerOption != null) {
            return ResponseEntity.ok(answerOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova opção de resposta
    @PostMapping
    public ResponseEntity<AnswerOption> createAnswerOption(@RequestBody AnswerOption answerOption) {
        AnswerOption newAnswerOption = answerOptionService.saveAnswerOption(answerOption);
        return ResponseEntity.ok(newAnswerOption);
    }

    // Atualizar uma opção de resposta existente
    @PutMapping("/{id}")
    public ResponseEntity<AnswerOption> updateAnswerOption(@PathVariable Long id, @RequestBody AnswerOption answerOptionDetails) {
        AnswerOption updatedAnswerOption = answerOptionService.updateAnswerOption(id, answerOptionDetails);
        if (updatedAnswerOption != null) {
            return ResponseEntity.ok(updatedAnswerOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma opção de resposta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswerOption(@PathVariable Long id) {
        boolean isDeleted = answerOptionService.deleteAnswerOption(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}