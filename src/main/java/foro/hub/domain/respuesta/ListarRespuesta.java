package foro.hub.domain.respuesta;
import java.time.LocalDateTime;

public record ListarRespuesta(
        Long id,
        String solucion,
        Long idUsuario,
        Long idCurso,
        LocalDateTime fecha){

    public ListarRespuesta(Respuesta respuesta){
        this(respuesta.getId(),
                respuesta.getSolucion(),
                respuesta.getAutor().getId(),
                respuesta.getCurso().getId(),
                respuesta.getFecha());
    }
}