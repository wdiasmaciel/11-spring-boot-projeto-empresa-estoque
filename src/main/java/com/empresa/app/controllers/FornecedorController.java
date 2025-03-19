package com.empresa.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.empresa.app.dtos.FornecedorDto;
import com.empresa.app.services.FornecedorService;

@CrossOrigin("*") // Para evitar problemas de CORS.
@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorDto> findAll() {
        List<FornecedorDto> listaFornecedorDto = fornecedorService.findAll();
        return listaFornecedorDto;
    }

    @GetMapping(value = "/{id}")
    public FornecedorDto findById(@PathVariable UUID id) {
        return fornecedorService.findById(id);
    }

    @PostMapping
    public FornecedorDto create(@RequestBody FornecedorDto fornecedorDto) {
        return fornecedorService.save(fornecedorDto);
    }

    @PutMapping("/{id}")
    public FornecedorDto update(@PathVariable UUID id, @RequestBody FornecedorDto fornecedorDtoAtualizado) {
        FornecedorDto fornecedorDtoExistente = fornecedorService.findById(id);
        if (fornecedorDtoExistente != null) {
            fornecedorDtoExistente.setNome(fornecedorDtoAtualizado.getNome());
            fornecedorDtoExistente.setTelefone(fornecedorDtoAtualizado.getTelefone());
            fornecedorDtoExistente.setEndereco(fornecedorDtoAtualizado.getEndereco());
            return fornecedorService.save(fornecedorDtoExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        fornecedorService.delete(id);
    }
}
