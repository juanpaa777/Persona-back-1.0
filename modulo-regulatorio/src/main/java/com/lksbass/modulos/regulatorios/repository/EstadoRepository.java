package com.lksbass.modulos.regulatorios.repository;

import com.lksbass.modulos.regulatorios.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByPaisId(Long paisId);
}
