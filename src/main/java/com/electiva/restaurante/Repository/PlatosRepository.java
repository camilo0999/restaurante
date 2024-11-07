package com.electiva.restaurante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electiva.restaurante.Models.Platos;

@Repository
public interface PlatosRepository extends JpaRepository<Platos, Long> {
    
}
