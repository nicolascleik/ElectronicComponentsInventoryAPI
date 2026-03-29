package com.inventario.componentes.communication.controllers;

import com.inventario.componentes.core.usecases.CreateComponentUseCase;
import com.inventario.componentes.core.usecases.DeleteComponentUseCase;
import com.inventario.componentes.core.usecases.ListComponentsUseCase;
import com.inventario.componentes.core.usecases.UpdateComponentUseCase;
import com.inventario.componentes.core.usecases.dtos.ComponentResponseDTO;
import com.inventario.componentes.core.usecases.dtos.CreateComponentRequestDTO;
import com.inventario.componentes.core.usecases.dtos.UpdateComponentRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/componentes")
@RequiredArgsConstructor
public class ComponentController {
    private final CreateComponentUseCase createComponentUseCase;
    private final ListComponentsUseCase listComponentsUseCase;
    private final DeleteComponentUseCase deleteComponentUseCase;
    private final UpdateComponentUseCase updateComponentUseCase;

    @GetMapping
    public List<ComponentResponseDTO> listarTodos(){
        return listComponentsUseCase.listarTodos();
    }

    @PostMapping
    public ComponentResponseDTO criarComponente(@RequestBody CreateComponentRequestDTO dto){
        return createComponentUseCase.registarComponente(dto);
    }

    @PutMapping("/{id}")
    public ComponentResponseDTO atualizarComponente(@PathVariable String id, @RequestBody UpdateComponentRequestDTO dto){
        return updateComponentUseCase.atualizarComponente(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletarComponentePorId(@PathVariable String id){
        deleteComponentUseCase.deletarComponente(id);
    }
}
