package br.com.rlag.alfabetiza.contentservice.repository;

import br.com.rlag.alfabetiza.contentservice.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
