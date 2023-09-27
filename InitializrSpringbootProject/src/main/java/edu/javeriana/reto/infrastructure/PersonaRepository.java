package edu.javeriana.reto.infrastructure;

import edu.javeriana.reto.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dinan
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
