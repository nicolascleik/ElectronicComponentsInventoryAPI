package com.inventario.componentes.communication.repositories;

import com.inventario.componentes.core.entities.EletronicComponent;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;
import com.inventario.componentes.core.usecases.interfaces.ComponentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryComponentRepository implements ComponentRepository {
    private final List<EletronicComponent> componentes = new ArrayList<>();

    @Override
    public EletronicComponent salvar(EletronicComponent componente) {
        componentes.add(componente);
        return componente;
    }

    @Override
    public List<EletronicComponent> listarTodos() {
        return componentes;
    }

    @Override
    public Optional<EletronicComponent> buscarPorId(String id) {
        return componentes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deletar(String id) {
        componentes.removeIf(componente -> componente.getId().equals(id));
    }
}
