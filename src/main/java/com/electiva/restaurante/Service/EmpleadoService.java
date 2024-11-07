package com.electiva.restaurante.Service;

import com.electiva.restaurante.Models.Empleado;

import java.util.List;

public interface  EmpleadoService {

    public void crearEmpleado(Empleado empleado);

    public Empleado buscarPorId(Long id);

    public void borrarPorId(Long id);

    public void actualizarEmpleado(Empleado empleado);

    public List<Empleado> buscarTodos();
    
}
