package foro.hub.domain.respuesta;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record RespuestaActualizada(
        @NotNull
        Long id,
        String solucion,
        @NotNull
        Long idUsuario,
        @NotNull
        Long idCurso,
        LocalDateTime fecha
) {
}