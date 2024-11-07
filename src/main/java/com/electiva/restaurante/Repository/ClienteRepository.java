package com.electiva.restaurante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electiva.restaurante.Models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
