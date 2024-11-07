package com.electiva.restaurante.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.electiva.restaurante.Models.Empleado;
import com.electiva.restaurante.Models.Pedidos;
import com.electiva.restaurante.Models.Platos;
import com.electiva.restaurante.Service.ClienteService;
import com.electiva.restaurante.Service.EmpleadoService;
import com.electiva.restaurante.Service.PedidosService;
import com.electiva.restaurante.Service.PlatosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;






@Controller
@RequestMapping("/admin")
public class AdminController {
    
    private final EmpleadoService empleadoService;
    private final PlatosService platosService;
    private final ClienteService clienteService;
    private final PedidosService pedidosService;



    public AdminController(EmpleadoService empleadoService, PlatosService platosService, ClienteService clienteService, PedidosService pedidosService) {
        this.empleadoService = empleadoService;
        this.platosService = platosService;
        this.clienteService = clienteService;
        this.pedidosService = pedidosService;
    }
    
    


    @GetMapping("/empleados")
    public String mostrarEmpleados(Model model) {
        model.addAttribute("empleados", empleadoService.buscarTodos());
        model.addAttribute("empleado", new Empleado());
        return "adminEmpleados";
    }

    @PostMapping("/registrarEmpleado")
    public String registroEmpleado(@ModelAttribute("empleado") Empleado entity) {
        //TODO: process POST request

        empleadoService.crearEmpleado(entity);
        
        return "redirect:/admin/empleados";
    }

    @GetMapping("/platos")
    public String mostrarPlatos(Model model) {
        model.addAttribute("platos", new Platos());
        model.addAttribute("platosList", platosService.buscarTodos());

        return "adminPlatos";
    }
    

    @PostMapping("/registrarPlato")
    public String registrarPlato(@ModelAttribute("platos") Platos entity, MultipartFile file) {
        platosService.crearPlatos(entity, file);
        return "redirect:/admin/platos";
    }

    @GetMapping("/inicio")
    public String mostrarInicio(Model modelo) {

        return "admin";
    }

    @GetMapping("/pedidos")
    public String mostrarPedidos(Model model) {
        model.addAttribute("pedidos", new Pedidos());
        model.addAttribute("listaPlatos", platosService.buscarTodos());
        model.addAttribute("listaPedidos", pedidosService.buscarTodos());
        model.addAttribute("listaPlatos", platosService.buscarTodos());
        model.addAttribute("listaClientes", clienteService.buscarTodos());
        return "adminPedidos";
    }

    @PostMapping("/pedidosCrear")
    public String mostrarPedidos(
        @ModelAttribute("pedidos") Pedidos pedidos,
    @RequestParam("idCliente") Long cliente,
    @ModelAttribute("platos") Platos platos
    )
     {
        System.out.println("Prueba: "+cliente);
        pedidosService.crearPedidos(pedidos, cliente, platos);
        
        return "redirect:/admin/pedidos";
    }

    @PostMapping("/cambiarEstado/{id}")
    public String cambiarEstado(@PathVariable("id") Long id) {
        pedidosService.cambiarEstado(id);
        return "redirect:/admin/pedidos";
    }

    @GetMapping("/clientes")
    public String postMethodName(Model model) {
        model.addAttribute("listaClientes", clienteService.buscarTodos());
        return "adminCliente";
    }
    

    
    
    
    
    
}
