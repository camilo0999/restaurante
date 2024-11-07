package com.electiva.restaurante.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electiva.restaurante.Models.Cliente;
import com.electiva.restaurante.Service.ClienteService;
import com.electiva.restaurante.Service.PlatosService;
import com.electiva.restaurante.Service.PlatosServiceImp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/publico")
public class PublicoController {

    private final ClienteService clienteService;
    private final PlatosService platosService;


    public PublicoController(ClienteService clienteService, PlatosServiceImp platosService) {
        this.clienteService = clienteService;
        this.platosService = platosService;
    }

    @GetMapping("/menu")
    public String mostrarMenu(Model model) {

        model.addAttribute("platosList", platosService.buscarTodos());
        return "menu";
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "Login";
    }

    @PostMapping("/iniciarSesion")
    public String postMethodName(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena) {

        if (usuario.equals("admin") && contrasena.equals("123456")) {
            return "redirect:/admin/inicio";
        }
        return "Login";

    }
    

    @GetMapping("/paginaRegistro")
    public String  paginaRegistro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registroCliente";
    }

    @GetMapping("/inicio")
    public String mostrarInicio(Model model) {

        model.addAttribute("platosList", platosService.buscarTodos());
        return "index";
    }
    


    @PostMapping("/registroCliente")
    public String postMethodName(@ModelAttribute("cliente") Cliente cliente) {
    
        clienteService.crearCliente(cliente);
        
        return "redirect:/publico/paginaRegistro";
    }
    
    
    
    
}
