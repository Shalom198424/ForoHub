package foro.hub.domain.curso;

public record DatosRespuestaCurso(Long id, String titulo, String mensaje,
                                  String creacion, Estado estado, String autor,
                                  String curso) {
}
