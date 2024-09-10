package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.Unit;
import br.com.rlag.alfabetiza.contentservice.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit getUnitById(Long id) {
        return unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
    }

    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Long id, Unit unitDetails) {
        Unit unit = getUnitById(id);
        unit.setName(unitDetails.getName());
        unit.setDescription(unitDetails.getDescription());
        unit.setObjectives(unitDetails.getObjectives());
        return unitRepository.save(unit);
    }

    public void deleteUnit(Long id) {
        unitRepository.deleteById(id);
    }
}