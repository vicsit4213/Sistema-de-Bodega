package gt.edu.url.sistema_control_inventario_bodega_automotriz.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import gt.edu.url.sistema_control_inventario_bodega_automotriz.model.Usuario;
import gt.edu.url.sistema_control_inventario_bodega_automotriz.repository.UsuarioRepository;

@Component
public class CargadorUsuarios implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CargadorUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByCorreo("admin@bodega.com").isEmpty()) {
            Usuario u = new Usuario();
            u.setCorreo("admin@bodega.com");
            u.setContrasena(passwordEncoder.encode("123456"));
            u.setNombre("Administrador");
            u.setApellido("Sistema");
            usuarioRepository.save(u);
            System.out.println("¡Usuario administrador creado con éxito!");
        }
    }
}