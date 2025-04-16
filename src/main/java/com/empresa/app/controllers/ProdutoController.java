package com.empresa.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.empresa.app.dtos.ProdutoRequestDto;
import com.empresa.app.dtos.ProdutoResponseDto;
import com.empresa.app.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoResponseDto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProdutoResponseDto findById(@PathVariable UUID id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public ProdutoResponseDto create(@RequestBody @Valid ProdutoRequestDto produtoRequestDto) {
        return produtoService.save(produtoRequestDto);
    }

    @PutMapping("/{id}")
    public ProdutoResponseDto update(@PathVariable UUID id, @RequestBody @Valid ProdutoRequestDto produtoRequestDtoComAtualizacao) {
        return produtoService.update(id, produtoRequestDtoComAtualizacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        produtoService.delete(id);
    }
}
