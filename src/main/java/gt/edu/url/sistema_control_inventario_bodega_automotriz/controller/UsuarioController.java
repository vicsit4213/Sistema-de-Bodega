package gt.edu.url.sistema_control_inventario_bodega_automotriz.controller;

import gt.edu.url.sistema_control_inventario_bodega_automotriz.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        // Carga todos los usuarios registrados en la bodega para mostrarlos en la tabla
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "listaUsuarios"; // Coincide exactamente con tu archivo listaUsuarios.html
    }
}