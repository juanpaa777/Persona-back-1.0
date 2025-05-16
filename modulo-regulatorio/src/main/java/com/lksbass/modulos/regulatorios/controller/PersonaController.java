package com.lksbass.modulos.regulatorios.controller;


import com.lksbass.modulos.regulatorios.model.Persona;
import com.lksbass.modulos.regulatorios.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        try {
            Persona saved = personaService.save(persona);
            if (saved.getId() == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.created(new URI("/personas/" + saved.getId())).body(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.deleteById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @RequestBody Persona persona) {
        Optional<Persona> existente = personaService.findById(id);
        if (existente.isPresent()) {
            persona.setId(id);
            return ResponseEntity.ok(personaService.save(persona));
        }
        return ResponseEntity.notFound().build();
    }
}

