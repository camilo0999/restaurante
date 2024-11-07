package com.electiva.restaurante.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.electiva.restaurante.Models.Cliente;
import com.electiva.restaurante.Repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }   

    @Override
    public void crearCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
    
}
