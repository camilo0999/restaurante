package com.electiva.restaurante.Service;

import com.electiva.restaurante.Models.Platos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface PlatosService {

    public void crearPlatos(Platos platos, MultipartFile file);

    public Platos buscarPorId(Long id);

    public void borrarPorId(Long id);

    public void actualizarPlatos(Platos platos);
    
    public List<Platos> buscarTodos();
    
}
