package br.com.rlag.alfabetiza.contentservice.repository;

import br.com.rlag.alfabetiza.contentservice.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
