package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.Unit;
import br.com.rlag.alfabetiza.contentservice.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    public Unit getUnitById(Long id) {
        return unitRepository.findById(id).orElse(null);
    }

    public Unit saveUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    public Unit updateUnit(Long id, Unit unitDetails) {
        Optional<Unit> optionalUnit = unitRepository.findById(id);
        if (optionalUnit.isPresent()) {
            Unit unit = optionalUnit.get();
            unit.setName(unitDetails.getName());
            unit.setDescription(unitDetails.getDescription());
            unit.setObjectives(unitDetails.getObjectives());
            unit.setLessons(unitDetails.getLessons());
            return unitRepository.save(unit);
        } else {
            return null;
        }
    }

    public boolean deleteUnit(Long id) {
        if (unitRepository.existsById(id)) {
            unitRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}