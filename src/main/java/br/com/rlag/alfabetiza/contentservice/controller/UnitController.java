package br.com.rlag.alfabetiza.contentservice.controller;

import br.com.rlag.alfabetiza.contentservice.model.Unit;
import br.com.rlag.alfabetiza.contentservice.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    // Obter todas as unidades
    @GetMapping
    public ResponseEntity<List<Unit>> getAllUnits() {
        List<Unit> units = unitService.getAllUnits();
        return ResponseEntity.ok(units);
    }

    // Obter uma unidade por ID
    @GetMapping("/{id}")
    public ResponseEntity<Unit> getUnitById(@PathVariable Long id) {
        Unit unit = unitService.getUnitById(id);
        if (unit != null) {
            return ResponseEntity.ok(unit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar uma nova unidade
    @PostMapping
    public ResponseEntity<Unit> createUnit(@RequestBody Unit unit) {
        Unit newUnit = unitService.saveUnit(unit);
        return ResponseEntity.ok(newUnit);
    }

    // Atualizar uma unidade existente
    @PutMapping("/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable Long id, @RequestBody Unit unitDetails) {
        Unit updatedUnit = unitService.updateUnit(id, unitDetails);
        if (updatedUnit != null) {
            return ResponseEntity.ok(updatedUnit);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar uma unidade
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        boolean isDeleted = unitService.deleteUnit(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
