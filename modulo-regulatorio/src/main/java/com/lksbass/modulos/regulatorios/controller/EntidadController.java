package com.lksbass.modulos.regulatorios.controller;

import com.lksbass.modulos.regulatorios.model.Entidad;
import com.lksbass.modulos.regulatorios.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/entidades")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    // GET all
    @GetMapping
    public List<Entidad> getAll() {
        return entidadService.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<Entidad> getById(@PathVariable Long id) {
        Optional<Entidad> entidad = entidadService.findById(id);
        return entidad.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create
    @PostMapping
    public ResponseEntity<Entidad> create(@RequestBody Entidad entidad) {
        return ResponseEntity.ok(entidadService.save(entidad));
    }

    // PUT update
    @PutMapping("/{id}")
    public ResponseEntity<Entidad> update(@PathVariable Long id, @RequestBody Entidad entidad) {
        Optional<Entidad> existente = entidadService.findById(id);
        if (existente.isPresent()) {
            Entidad actualizada = existente.get();
            actualizada.setNombre(entidad.getNombre());
            return ResponseEntity.ok(entidadService.save(actualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (entidadService.findById(id).isPresent()) {
            entidadService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
