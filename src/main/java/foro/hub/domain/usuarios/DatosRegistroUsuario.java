package foro.hub.domain.usuarios;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroUsuario(
        Long id,
        @NotBlank
        String nombre,
        @NotBlank (message = "Utilice su correo electrónico como nombre de usuario")
        @Email
        String username,
        @NotBlank
        String email,
        @NotBlank(message = "Debe tener entre 6 y 10 caracteres.") @Pattern(regexp = "\\d{6,10}")
        String password

        /*Perfil perfil*/
) {
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public boolean activo() {

        return true;
    }
}