package com.lksbass.modulos.regulatorios.service;

import com.lksbass.modulos.regulatorios.model.Entidad;
import com.lksbass.modulos.regulatorios.repository.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {

    @Autowired
    private EntidadRepository entidadRepository;

    public List<Entidad> findAll() {
        return entidadRepository.findAll();
    }

    public Optional<Entidad> findById(Long id) {
        return entidadRepository.findById(id);
    }

    public Entidad save(Entidad entidad) {
        return entidadRepository.save(entidad);
    }

    public void deleteById(Long id) {
        entidadRepository.deleteById(id);
    }
}
