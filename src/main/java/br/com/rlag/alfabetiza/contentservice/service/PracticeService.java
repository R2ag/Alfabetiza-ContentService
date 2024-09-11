package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.Practice;
import br.com.rlag.alfabetiza.contentservice.repository.PracticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticeService {

    @Autowired
    private PracticeRepository practiceRepository;

    public List<Practice> getAllPractices() {
        return practiceRepository.findAll();
    }

    public Practice getPracticeById(Long id) {
        return practiceRepository.findById(id).orElse(null);
    }

    public Practice savePractice(Practice practice) {
        return practiceRepository.save(practice);
    }

    public Practice updatePractice(Long id, Practice practiceDetails) {
        Optional<Practice> optionalPractice = practiceRepository.findById(id);
        if (optionalPractice.isPresent()) {
            Practice practice = optionalPractice.get();
            practice.setDescription(practiceDetails.getDescription());
            practice.setImageUrl(practiceDetails.getImageUrl());
            practice.setAnswerOptions(practiceDetails.getAnswerOptions());
            return practiceRepository.save(practice);
        } else {
            return null;
        }
    }

    public boolean deletePractice(Long id) {
        if (practiceRepository.existsById(id)) {
            practiceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}