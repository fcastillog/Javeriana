package edu.javeriana.reto.application;

import edu.javeriana.reto.application.exception.ResourceNotFoundException;
import edu.javeriana.reto.dominio.TipoIdentificacion;
import edu.javeriana.reto.infrastructure.TipoIdentificacionRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dinan
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class TipoIdentificacionController {

    @Autowired
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    @GetMapping("/tipoIdentificacion")
    public List<TipoIdentificacion> getAll() {
        return tipoIdentificacionRepository.findAll();
    }

    @PostMapping("/tipoIdentificacion")
    public TipoIdentificacion create(@RequestBody TipoIdentificacion tipoIdentificacion) {
        return tipoIdentificacionRepository.save(tipoIdentificacion);
    }

    @GetMapping("/tipoIdentificacion/{id}")
    public ResponseEntity<TipoIdentificacion> getById(@PathVariable Long id) {
        TipoIdentificacion tipoIdentificacion = tipoIdentificacionRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de Identificación :" + id));

        return ResponseEntity.ok(tipoIdentificacion);
    }

    @PutMapping("/tipoIdentificacion/{id}")
    public ResponseEntity<TipoIdentificacion> update(@PathVariable Long id, @RequestBody TipoIdentificacion tipoIdentificacionDetalle) {
        TipoIdentificacion tipoIdentificacion = tipoIdentificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el tipo de Identificación :" + id));
        tipoIdentificacion.setNombre(tipoIdentificacionDetalle.getNombre());
        TipoIdentificacion updatedTipoIdentificacion = tipoIdentificacionRepository.save(tipoIdentificacion);
        return ResponseEntity.ok(updatedTipoIdentificacion);
    }

    @DeleteMapping("/tipoIdentificacion/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
         TipoIdentificacion tipoIdentificacion = tipoIdentificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la cita :" + id));

        tipoIdentificacionRepository.delete(tipoIdentificacion);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
