package com.inventario.componentes.core.usecases;

import com.inventario.componentes.core.entities.EletronicComponent;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;
import com.inventario.componentes.core.usecases.dtos.CreateComponentRequestDTO;
import com.inventario.componentes.core.usecases.interfaces.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateComponentUseCase {
    private final ComponentRepository repository;

    public ComponentResponseDTO registarComponente(CreateComponentRequestDTO dto){
        String id = UUID.randomUUID().toString();
        String modelo = dto.getModelo();
        String categoria = dto.getCategoria();
        int quantidade = dto.getQuantidade();

        EletronicComponent componente = new EletronicComponent(id, modelo, categoria, quantidade);

        repository.salvar(componente);

        return new ComponentResponseDTO(id, modelo, categoria, quantidade);
    }
}
