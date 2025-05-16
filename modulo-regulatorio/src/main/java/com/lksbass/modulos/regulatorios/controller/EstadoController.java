package com.lksbass.modulos.regulatorios.controller;

import com.lksbass.modulos.regulatorios.model.Estado;
import com.lksbass.modulos.regulatorios.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Estado>> getByPais(@PathVariable Long id) {
        return ResponseEntity.ok(estadoService.findAllByCountry(id));
    }
}
