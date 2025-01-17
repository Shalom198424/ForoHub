package foro.hub.controller;

import foro.hub.domain.curso.CursoRepository;
import foro.hub.domain.respuesta.*;
import foro.hub.domain.usuarios.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("respuestas")
@ResponseBody
@SecurityRequirement(name="bearer-key")

    public class RespuestaController {
        @Autowired
        private CursoRepository cursoRepository;
        @Autowired
        private UsuarioRepository usuarioRepository;
        @Autowired
        private RespuestaService respuestaService;
        @Autowired
        private RespuestaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity respuestaRegistrada (@RequestBody @Valid Respuesta respuesta) throws ValidacionDeIntegridad {
        var respuestaRegistrada = respuestaService.datosDetalleRespuesta(respuesta);
        return ResponseEntity.ok(respuestaRegistrada);
    }

    @GetMapping("/respuestas")
    public ResponseEntity<Page<ListarRespuesta>> listarRespuestas(@PageableDefault(size = 10) Pageable paged){
        return ResponseEntity.ok(repository.findByActivoTrue(paged).map(ListarRespuesta::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity respuestaActualizada(@RequestBody @Valid RespuestaActualizada respuestaActualizada){
        Respuesta respuesta=repository.getReferenceById(respuestaActualizada.id());
        respuesta.respuestaActualizada(respuestaActualizada);
        return ResponseEntity.ok(new DatosDetalleRespuesta(respuesta.getId(),respuesta.getSolucion(),
                respuesta.getAutor().getId(),
                respuesta.getCurso().getId(),
                respuesta.getFecha()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id){
        Respuesta respuesta = repository.getReferenceById(id);
        respuesta.diactivateResponse();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity <DatosDetalleRespuesta> respuestaCreada(@PathVariable Long id){
        Respuesta respuesta=repository.getReferenceById(id);
        var datosDetalleRespuesta = new DatosDetalleRespuesta(respuesta.getId(),
                respuesta.getSolucion(),
                respuesta.getAutor().getId(),
                respuesta.getCurso().getId(),
                respuesta.getFecha());
        return ResponseEntity.ok(datosDetalleRespuesta);
    }
}
