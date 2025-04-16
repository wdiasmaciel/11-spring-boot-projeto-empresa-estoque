package com.empresa.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.ProdutoModel;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
