package com.empresa.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.FornecedorModel;

import java.util.UUID;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, UUID> {
}
