package foro.hub.domain.respuesta;

import foro.hub.domain.curso.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(

        @NotBlank
        String solucion,
        @NotNull
        @Valid
        Long idUsuario,
        @NotNull
        @Valid
        Long idCurso,
        LocalDateTime fecha)

 {

 }
