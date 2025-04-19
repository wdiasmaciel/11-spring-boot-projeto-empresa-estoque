package com.empresa.app.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.IdentificacaoModel;

public interface IdentificacaoRepository extends JpaRepository<IdentificacaoModel, UUID> {
}
