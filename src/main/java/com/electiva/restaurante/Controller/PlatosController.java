package com.electiva.restaurante.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electiva.restaurante.Models.Platos;
import com.electiva.restaurante.Service.PlatosService;

@Controller
@RequestMapping("/platos")
public class PlatosController {

    private final PlatosService platosService;

    public PlatosController(PlatosService platosService) {
        this.platosService = platosService;
    }

    @GetMapping("/ver/{id}")
    public String mostrarPlato(@PathVariable Long id, Model model) {
        Platos plato = platosService.buscarPorId(id);
        model.addAttribute("plato", plato);
        return "plato"; // Asegúrate de que este nombre coincida con tu archivo HTML de detalles
    }


    
    
}
