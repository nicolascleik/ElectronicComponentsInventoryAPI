package com.inventario.componentes.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EletronicComponent {
    private String id;
    private String modelo;
    private String categoria;
    private int quantidade;
}
