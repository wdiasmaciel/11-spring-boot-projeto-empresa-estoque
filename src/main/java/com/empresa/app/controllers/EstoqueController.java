package com.empresa.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.empresa.app.dtos.EstoqueDto;
import com.empresa.app.services.EstoqueService;

@RestController
@RequestMapping(value = "/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<EstoqueDto> findAll() {
        return estoqueService.findAll();
    }

    @GetMapping(value = "/{id}/{cnpj}")
    public EstoqueDto findById(@PathVariable UUID id, @PathVariable String cnpj) {
        return estoqueService.findById_produdtoCnpj_filial(id, cnpj);
    }

    @PostMapping
    public EstoqueDto create(@RequestBody @Valid EstoqueDto estoqueDto) {
        return estoqueService.save(estoqueDto);
    }

    @PutMapping("/{id}/{cnpj}")
    public EstoqueDto update(@PathVariable UUID id, @PathVariable String cnpj,
            @RequestBody @Valid EstoqueDto estoqueDtoComAtualizacao) {
        return estoqueService.update(id, cnpj, estoqueDtoComAtualizacao);
    }

    @DeleteMapping("/{id}/{cnpj}")
    public void delete(@PathVariable UUID id, @PathVariable String cnpj) {
        estoqueService.delete(id, cnpj);
    }
}
