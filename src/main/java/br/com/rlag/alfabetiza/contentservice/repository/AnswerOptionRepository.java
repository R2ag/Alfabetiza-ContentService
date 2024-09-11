package br.com.rlag.alfabetiza.contentservice.repository;

import br.com.rlag.alfabetiza.contentservice.model.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
}
