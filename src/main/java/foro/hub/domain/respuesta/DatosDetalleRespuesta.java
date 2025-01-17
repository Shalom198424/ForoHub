package foro.hub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long id,
        String solucion,
        Long idCurso,
        Long idUsuario,
        LocalDateTime fecha) {

    public DatosDetalleRespuesta(Respuesta rVerified) {
        this(rVerified.getId(),rVerified.getSolucion(),rVerified.getAutor().getId(),rVerified.getCurso().getId(),rVerified.getFecha());
    }
}
