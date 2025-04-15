package com.empresa.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.app.models.FilialModel;

public interface FilialRepository extends JpaRepository<FilialModel, String> {
}
