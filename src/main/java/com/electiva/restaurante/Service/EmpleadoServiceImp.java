package com.electiva.restaurante.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.electiva.restaurante.Models.Empleado;
import com.electiva.restaurante.Repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImp implements EmpleadoService{

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImp(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void crearEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarPorId(Long id) {
        
        empleadoRepository.deleteById(id);

    }

    @Override
    public void actualizarEmpleado(Empleado empleado) {
        Empleado empleadoEncontrado = buscarPorId(empleado.getId());
        empleadoEncontrado.setNombre(empleado.getNombre());
        empleadoEncontrado.setApellido(empleado.getApellido());
        empleadoEncontrado.setTelefono(empleado.getTelefono());
        empleadoEncontrado.setEmail(empleado.getEmail());
        empleadoEncontrado.setCargo(empleado.getCargo());
        empleadoRepository.save(empleadoEncontrado);
    }

    @Override
    public List<Empleado> buscarTodos() {
       return empleadoRepository.findAll();
    }
    
}
