package foro.hub.domain.curso;

public record DatosListadoCurso(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso
) {
    public DatosListadoCurso(Curso curso) {
        this(curso.getId(), curso.getTitulo(), curso.getMensaje(),
                curso.getAutor(), curso.getCurso());
    }
}
