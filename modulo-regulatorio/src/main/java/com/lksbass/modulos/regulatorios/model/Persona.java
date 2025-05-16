package com.lksbass.modulos.regulatorios.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;
}
