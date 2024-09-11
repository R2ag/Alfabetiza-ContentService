package br.com.rlag.alfabetiza.contentservice.service;

import br.com.rlag.alfabetiza.contentservice.model.AnswerOption;
import br.com.rlag.alfabetiza.contentservice.repository.AnswerOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerOptionService {

    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    public List<AnswerOption> getAllAnswerOptions() {
        return answerOptionRepository.findAll();
    }

    public AnswerOption getAnswerOptionById(Long id) {
        return answerOptionRepository.findById(id).orElse(null);
    }

    public AnswerOption saveAnswerOption(AnswerOption answerOption) {
        return answerOptionRepository.save(answerOption);
    }

    public AnswerOption updateAnswerOption(Long id, AnswerOption answerOptionDetails) {
        Optional<AnswerOption> optionalAnswerOption = answerOptionRepository.findById(id);
        if (optionalAnswerOption.isPresent()) {
            AnswerOption answerOption = optionalAnswerOption.get();
            answerOption.setDescription(answerOptionDetails.getDescription());
            answerOption.setImageUrl(answerOptionDetails.getImageUrl());
            answerOption.setCorrect(answerOptionDetails.isCorrect());
            answerOption.setPractice(answerOptionDetails.getPractice());
            return answerOptionRepository.save(answerOption);
        } else {
            return null;
        }
    }

    public boolean deleteAnswerOption(Long id) {
        if (answerOptionRepository.existsById(id)) {
            answerOptionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}