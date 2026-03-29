package com.inventario.componentes.core.usecases.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateComponentRequestDTO {
    private String modelo;
    private String categoria;
    private int quantidade;
}
