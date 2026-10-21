package gt.edu.url.sistema_control_inventario_bodega_automotriz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gt.edu.url.sistema_control_inventario_bodega_automotriz.model.Usuario;

@Controller
public class AccesoController {

    @GetMapping("/")
    public String inicio(Model model) {
        // Añade el objeto que el formulario de registro de tu login.html está esperando
        model.addAttribute("usuarioRegistro", new Usuario());
        return "login"; // Carga directamente tu login.html
    }

    @GetMapping("/login")
    public String login(Model model) {
        // Atrapa la redirección al cerrar sesión (/login?salio) y carga la vista correctamente
        model.addAttribute("usuarioRegistro", new Usuario());
        return "login"; 
    }

    @GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "acceso-denegado";
    }
}