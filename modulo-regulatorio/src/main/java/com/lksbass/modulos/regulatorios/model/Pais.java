package com.lksbass.modulos.regulatorios.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
