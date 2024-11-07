package com.electiva.restaurante.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.electiva.restaurante.Models.Platos;
import com.electiva.restaurante.Repository.PlatosRepository;

@Service
public class PlatosServiceImp implements PlatosService{
    private final PlatosRepository platosRepository;
    private final ImagenServices imagenService;

    public PlatosServiceImp(PlatosRepository platosRepository, ImagenServices imagenService) {
        this.platosRepository = platosRepository;
        this.imagenService = imagenService;
    }


    @Override
    public void crearPlatos(Platos platos, MultipartFile file) {

        String imagen = imagenService.unaImagen(file);
        
        platos.setImagen(imagen);

        platosRepository.save(platos);
    }

    @Override
    public Platos buscarPorId(Long id) {
       
        return platosRepository.findById(id).orElse(null);
    }

    @Override
    public void borrarPorId(Long id) {

        platosRepository.deleteById(id);
    }

    @Override
    public void actualizarPlatos(Platos platos) {
        
        Platos platosEncontrado = platosRepository.findById(platos.getId()).orElse(null);
        if (platosEncontrado != null) {
            platosEncontrado.setNombre(platos.getNombre());
            platosEncontrado.setPrecio(platos.getPrecio());
            platosEncontrado.setImagen(platos.getImagen());
            platosEncontrado.setCategoria(platos.getCategoria());
            platosRepository.save(platosEncontrado);
        }
    }

    @Override
    public List<Platos> buscarTodos() {
       
        return platosRepository.findAll();
    }
    
}
