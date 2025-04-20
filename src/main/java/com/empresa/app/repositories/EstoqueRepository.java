package com.empresa.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.EstoqueModel;
import com.empresa.app.models.EstoqueModelPk;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, EstoqueModelPk> {
}
