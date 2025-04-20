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

    @GetMapping
    public EstoqueDto findByIdCnpj(@RequestParam UUID id, @RequestParam String cnpj) {
        return estoqueService.findById_produdtoCnpj_filial(id, cnpj);
    }

    @PostMapping
    public EstoqueDto create(@RequestBody @Valid EstoqueDto estoqueDto) {
        return estoqueService.save(estoqueDto);
    }

    @PutMapping
    public EstoqueDto update(
            @RequestParam UUID id,
            @RequestParam String cnpj,
            @RequestBody @Valid EstoqueDto estoqueDtoComAtualizacao) {
        return estoqueService.update(id, cnpj, estoqueDtoComAtualizacao);
    }

    @DeleteMapping
    public void delete(@RequestParam UUID id, @RequestParam String cnpj) {
        estoqueService.delete(id, cnpj);
    }
}
