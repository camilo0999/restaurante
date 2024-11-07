package com.electiva.restaurante.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.electiva.restaurante.Models.Cliente;
import com.electiva.restaurante.Models.Pedidos;
import com.electiva.restaurante.Models.Platos;
import com.electiva.restaurante.Repository.ClienteRepository;
import com.electiva.restaurante.Repository.PedidosRepository;

@Service
public class PedidosServiceImp implements PedidosService{


    private final PedidosRepository pedidosRepository;
    private final PlatosService platosService;
    private final ClienteService clienteService;
    private final ClienteRepository clienteRepository;
    

    public PedidosServiceImp(PedidosRepository pedidosRepository, PlatosService platosService, ClienteService clienteService, ClienteRepository clienteRepository) {
        this.pedidosRepository = pedidosRepository;
        this.platosService = platosService;
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }
    
    @Override
    public void crearPedidos(Pedidos pedidos, Long idCliente, Platos platos)  {
        // Buscar el cliente
        Cliente cliente = clienteService.buscarPorId(idCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente no encontrado con ID: " + idCliente);
        }

        // Asegurarse de que las colecciones estén inicializadas
        if (cliente.getPedidos() == null) {
            cliente.setPedidos(new ArrayList<>());
        }
        if (platos.getPedidos() == null) {
            platos.setPedidos(new ArrayList<>());
        }

        // Agregar el pedido al cliente
        cliente.getPedidos().add(pedidos);
        
        // Agregar el pedido a los platos
        platos.getPedidos().add(pedidos);
        
        // Establecer datos del pedido
        pedidos.setPlatos(Collections.singletonList(platos)); // Asegúrate de que `setPlatos` acepte una lista
        pedidos.setFecha(new Date());
        pedidos.setEstado("En espera");
        pedidos.setTotal(platos.getPrecio() * pedidos.getCantidad());
        pedidos.setCliente(cliente);

        pedidosRepository.save(pedidos);


    }

    @Override
    public List<Pedidos> buscarTodos() {
        return pedidosRepository.findAll();
    }

    @Override
    public void cambiarEstado(Long id) {
        Pedidos pedidos = pedidosRepository.findById(id).orElse(null);
        if (pedidos != null) {
            pedidos.setEstado("Entregado");
            pedidosRepository.save(pedidos);
        }
    }
    
}
