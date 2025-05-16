package com.lksbass.modulos.regulatorios.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ubicacionpaisid")
    private Pais pais;

    @Column(name = "estadonombre")
    private String nombre;
}
