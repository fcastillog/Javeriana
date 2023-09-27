package edu.javeriana.reto.infrastructure;

import edu.javeriana.reto.dominio.TipoIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dinan
 */
@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long>{
    
}
