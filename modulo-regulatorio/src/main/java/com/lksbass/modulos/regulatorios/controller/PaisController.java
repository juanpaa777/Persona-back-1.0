package com.lksbass.modulos.regulatorios.controller;


import com.lksbass.modulos.regulatorios.model.Pais;
import com.lksbass.modulos.regulatorios.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> getAll() {
        return ResponseEntity.ok(paisService.findAll());
    }
}