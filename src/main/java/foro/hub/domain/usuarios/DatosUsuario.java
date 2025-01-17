package foro.hub.domain.usuarios;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DatosUsuario(
        @NotBlank(message = "Utilice su correo electrónico como nombre de usuario")
        @Email(message = "Email inválido.")
        String email,
        @NotBlank(message = "Debe tener entre 10 y 15 caracteres.")
        String password
) {

}