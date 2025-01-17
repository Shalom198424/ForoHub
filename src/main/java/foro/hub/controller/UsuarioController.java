package foro.hub.controller;


import foro.hub.domain.usuarios.*;
import foro.hub.domain.usuarios.ListadoUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@SecurityRequirement(name="bearer-key")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<Page<ListadoUsuario>> listadoUsuario(@PageableDefault(size = 10) Pageable paged){

        Pageable Page = null;
        return ResponseEntity.ok(usuarioRepository.findByActivoTrue(Page).map(ListadoUsuario::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity datosActualizarUsuario (@RequestBody @Valid DatosActualizarUsuario datosActualizarUsuario){
        Usuario usuario = usuarioRepository.getReferenceById(datosActualizarUsuario.id());
        usuario.datosActualizarUsuario(datosActualizarUsuario);
        return ResponseEntity.ok(new DatosActualizarUsuario(usuario.getId(),usuario.getNombre(), usuario.getEmail()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuario.desactivarUsuario();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity <DatosRespuestaUsuario> registrarUsuario(@PathVariable Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        var usuarioDetail = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre());
        return ResponseEntity.ok(usuarioDetail);
    }
}