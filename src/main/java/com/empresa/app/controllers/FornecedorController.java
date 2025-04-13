package com.empresa.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.empresa.app.dtos.FornecedorRequestDto;
import com.empresa.app.dtos.FornecedorResponseDto;
import com.empresa.app.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorResponseDto> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping(value = "/{id}")
    public FornecedorResponseDto findById(@PathVariable UUID id) {
        return fornecedorService.findById(id);
    }

    @PostMapping
    public FornecedorResponseDto create(@RequestBody @Valid FornecedorRequestDto fornecedorRequestDto) {
        return fornecedorService.save(fornecedorRequestDto);
    }

    @PutMapping("/{id}")
    public FornecedorResponseDto update(@PathVariable UUID id, @RequestBody @Valid FornecedorRequestDto fornecedorRequestDtoComAtualizacao) {
        return fornecedorService.update(id, fornecedorRequestDtoComAtualizacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        fornecedorService.delete(id);
    }
}
