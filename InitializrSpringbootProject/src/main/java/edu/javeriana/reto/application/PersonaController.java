package edu.javeriana.reto.application;

import edu.javeriana.reto.application.exception.ResourceNotFoundException;
import edu.javeriana.reto.dominio.Persona;
import edu.javeriana.reto.infrastructure.PersonaRepository;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/persona")
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @PostMapping("/persona")
    public Persona create(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<Persona> getById(@PathVariable Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona :" + id));
        return ResponseEntity.ok(persona);
    }

    @PutMapping("/persona/{id}")
    public ResponseEntity<Persona> update(@PathVariable Long id, @RequestBody Persona personaDetalle) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona :" + id));
        Persona updatedPersona = personaRepository.save(persona);
        return ResponseEntity.ok(updatedPersona);
    }

    @DeleteMapping("/persona/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la persona :" + id));
        personaRepository.delete(persona);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
