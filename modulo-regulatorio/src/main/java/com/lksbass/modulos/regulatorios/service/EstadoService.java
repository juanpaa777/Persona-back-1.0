package com.lksbass.modulos.regulatorios.service;

import com.lksbass.modulos.regulatorios.model.Estado;
import com.lksbass.modulos.regulatorios.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public List<Estado> findAllByCountry(Long idPais) {
        return estadoRepository.findByPaisId(idPais);
    }
}
