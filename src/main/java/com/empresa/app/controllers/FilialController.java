package com.empresa.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.empresa.app.dtos.FilialDto;
import com.empresa.app.services.FilialService;

@RestController
@RequestMapping(value = "/filiais")
public class FilialController {

    @Autowired
    private FilialService filialService;

    @GetMapping
    public List<FilialDto> findAll() {
        return filialService.findAll();
    }

    @GetMapping(value = "/{cnpj}")
    public FilialDto findById(@PathVariable String cnpj) {
        return filialService.findById(cnpj);
    }

    @PostMapping
    public FilialDto create(@RequestBody @Valid FilialDto filialDto) {
        return filialService.save(filialDto);
    }

    @PutMapping("/{cnpj}")
    public FilialDto update(@PathVariable String cnpj, @RequestBody @Valid FilialDto filialDtoComAtualizacao) {
        return filialService.update(cnpj, filialDtoComAtualizacao);
    }

    @DeleteMapping("/{cnpj}")
    public void delete(@PathVariable String cnpj) {
        filialService.delete(cnpj);
    }
}
