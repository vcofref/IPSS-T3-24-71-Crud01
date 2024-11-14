package cl.ipss.crud001s71.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.crud001s71.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
