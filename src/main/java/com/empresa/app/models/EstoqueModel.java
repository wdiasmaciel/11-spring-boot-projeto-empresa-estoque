package com.empresa.app.models;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class EstoqueModel {
    @NotNull
	private double preco;
    private int quantidade;

    private LocalDate validade;

	
}
