package foro.hub.domain.usuarios;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public record ListadoUsuario (
        Long id,
        String nombre,
        String email
){
    public ListadoUsuario(Usuario usuario){

        this(usuario.getId(),usuario.getNombre(),usuario.getEmail());
    }
}