package com.lksbass.modulos.regulatorios.service;


import com.lksbass.modulos.regulatorios.model.Pais;
import com.lksbass.modulos.regulatorios.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll() {
        return paisRepository.findAll();
    }
}