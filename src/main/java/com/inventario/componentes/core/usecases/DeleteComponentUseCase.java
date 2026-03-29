package com.inventario.componentes.core.usecases;

import com.inventario.componentes.core.usecases.interfaces.ComponentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteComponentUseCase {
    private final ComponentRepository repository;

    public void deletarComponente(String id){
        repository.deletar(id);
    }
}
