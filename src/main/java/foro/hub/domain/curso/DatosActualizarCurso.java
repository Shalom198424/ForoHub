package foro.hub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarCurso(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String creacion,
        Estado estado,
        String autor,
        String curso
) {
}
