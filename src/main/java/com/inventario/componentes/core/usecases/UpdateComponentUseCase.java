package com.inventario.componentes.core.usecases;

import com.inventario.componentes.core.entities.EletronicComponent;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;
import com.inventario.componentes.core.usecases.dtos.UpdateComponentRequestDTO;
import com.inventario.componentes.core.usecases.interfaces.ComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateComponentUseCase {
    private final ComponentRepository repository;

    public ComponentResponseDTO atualizarComponente(String id , UpdateComponentRequestDTO dto){
        EletronicComponent componente = repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Componente não encontrado!"));

        componente.setModelo(dto.getModelo());
        componente.setCategoria(dto.getCategoria());
        componente.setQuantidade(dto.getQuantidade());

        return new ComponentResponseDTO(componente.getId(),componente.getModelo(), componente.getCategoria(), componente.getQuantidade());
    }
}
