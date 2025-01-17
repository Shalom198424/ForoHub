package foro.hub.domain.usuarios;

import foro.hub.domain.respuesta.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public DatosRegistroUsuario datosRegistroUsuario(DatosRegistroUsuario datosRegistroUsuario) throws ValidacionDeIntegridad {
            // Verificar si el correo electrónico ya está registrado en la base de datos
            if (usuarioRepository.existsByEmail(datosRegistroUsuario.email())) {
                throw new ValidacionDeIntegridad("Este correo electrónico ya está registrado.");
            }
         {// Verificar si el nombre de usuario ya está en uso
            if (usuarioRepository.existsByUsername(datosRegistroUsuario.username())) {
                throw new ValidacionDeIntegridad("Este nombre de usuario ya está en uso.");
            }

            // Crear un nuevo usuario y cifrar la contraseña
            var usuario = new Usuario(datosRegistroUsuario, passwordEncoder);
            usuarioRepository.save(usuario);
            return new DatosRegistroUsuario(
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getEmail(),
                    usuario.getUsername(),
                    usuario.getPassword());
        }

    }

    public DatosRegistroUsuario datosRegistroUsuario(Long id, DatosActualizarUsuario datosActualizarUsuario) throws ValidacionDeIntegridad {
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("El usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        // Actualizar los campos del usuario si se proporcionan nuevos valores
        usuario.datosActualizarUsuario(datosActualizarUsuario);


        // Guardar el usuario actualizado en la base de datos
        usuarioRepository.save(usuario);
        return new DatosRegistroUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
    public DatosRegistroUsuario desactivarUsuario(Long id) throws ValidacionDeIntegridad {
        // Verificar si el usuario existe en la base de datos
        var usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            throw new ValidacionDeIntegridad("El usuario con el ID proporcionado no existe.");
        }

        var usuario = usuarioOptional.get();

        // Desactivar el usuario
        usuario.desactivarUsuario();

        // Guardar el usuario desactivado en la base de datos
        usuarioRepository.save(usuario);
        return new DatosRegistroUsuario(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getPassword());
    }
}