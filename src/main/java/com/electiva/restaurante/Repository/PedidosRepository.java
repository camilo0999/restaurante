package com.electiva.restaurante.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electiva.restaurante.Models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    
}
