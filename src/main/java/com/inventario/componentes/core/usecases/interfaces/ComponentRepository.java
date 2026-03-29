package com.inventario.componentes.core.usecases.interfaces;

import com.inventario.componentes.core.entities.EletronicComponent;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ComponentRepository {
    EletronicComponent salvar(EletronicComponent componente);
    List<EletronicComponent> listarTodos();
    Optional<EletronicComponent> buscarPorId(String id);
    void deletar(String id);
}
