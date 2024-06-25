package com.baggio.projeto.carros_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baggio.projeto.carros_backend.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
  
}
