package com.lksbass.modulos.regulatorios.repository;

import com.lksbass.modulos.regulatorios.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}