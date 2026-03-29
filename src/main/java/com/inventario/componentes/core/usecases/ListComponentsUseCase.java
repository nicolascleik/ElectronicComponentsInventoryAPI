package com.inventario.componentes.core.usecases;

import com.inventario.componentes.core.entities.EletronicComponent;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;
import com.inventario.componentes.core.usecases.interfaces.ComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListComponentsUseCase {
    private final ComponentRepository repository;

    public List<ComponentResponseDTO> listarTodos(){
        List<ComponentResponseDTO> componentResponseDTOList = new ArrayList<>();
        for(EletronicComponent component : repository.listarTodos()){
            ComponentResponseDTO dto = new ComponentResponseDTO(component.getId(), component.getModelo(), component.getCategoria(), component.getQuantidade());
            componentResponseDTOList.add(dto);
        }

        return componentResponseDTOList;
    }
}
