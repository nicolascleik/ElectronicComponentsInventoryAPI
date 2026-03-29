package com.inventario.componentes.core.usecases.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComponentResponseDTO {
    private String id;
    private String modelo;
    private String categoria;
    private int quantidade;
}
