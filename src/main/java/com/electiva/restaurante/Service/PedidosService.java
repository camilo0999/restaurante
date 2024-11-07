package com.electiva.restaurante.Service;

import java.util.List;

import com.electiva.restaurante.Models.Pedidos;
import com.electiva.restaurante.Models.Platos;

public interface PedidosService {

    public void crearPedidos(Pedidos pedidos, Long idCliente,Platos platos);

    public void cambiarEstado(Long id);

    public List<Pedidos> buscarTodos();
    
}
