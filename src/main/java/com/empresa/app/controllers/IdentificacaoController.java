package com.empresa.app.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.empresa.app.dtos.IdentificacaoDto;
import com.empresa.app.services.IdentificacaoService;

@RestController
@RequestMapping(value = "/identificacoes")
public class IdentificacaoController {

    @Autowired
    private IdentificacaoService identificacaoService;

    public IdentificacaoController(IdentificacaoService identificacaoService) {
        this.identificacaoService = identificacaoService;
    }

    @GetMapping
    public List<IdentificacaoDto> findAll() {
        return identificacaoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public IdentificacaoDto findById(@PathVariable UUID id) {
        return identificacaoService.findById(id);
    }

    @PostMapping
    public IdentificacaoDto create(@RequestBody @Valid IdentificacaoDto identificacaoDto) {
        return identificacaoService.save(identificacaoDto);
    }

    @PutMapping("/{id}")
    public IdentificacaoDto update(@PathVariable UUID id, @RequestBody @Valid IdentificacaoDto identificacaoDtoComAtualizacao) {
        return identificacaoService.update(id, identificacaoDtoComAtualizacao);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        identificacaoService.delete(id);
    }
}
