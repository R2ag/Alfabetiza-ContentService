package br.com.rlag.alfabetiza.contentservice.repository;

import br.com.rlag.alfabetiza.contentservice.model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
