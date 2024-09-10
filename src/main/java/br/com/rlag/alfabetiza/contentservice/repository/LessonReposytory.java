package br.com.rlag.alfabetiza.contentservice.repository;

import br.com.rlag.alfabetiza.contentservice.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonReposytory extends JpaRepository<Lesson, Integer> {
}
