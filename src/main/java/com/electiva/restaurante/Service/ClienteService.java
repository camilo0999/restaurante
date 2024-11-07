package com.electiva.restaurante.Service;

import com.electiva.restaurante.Models.Cliente;

import java.util.List;

public interface ClienteService {

    public void crearCliente(Cliente cliente);

    public List<Cliente> buscarTodos();

    public Cliente buscarPorId(Long id);
    
}
