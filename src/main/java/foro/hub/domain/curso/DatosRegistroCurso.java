package foro.hub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String creacion,
        @NotNull
        Estado estado,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
