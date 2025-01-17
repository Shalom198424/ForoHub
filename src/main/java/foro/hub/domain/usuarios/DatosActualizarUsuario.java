package foro.hub.domain.usuarios;


import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(
        @NotNull Long id,
        String nombre,
        String email
) {
}