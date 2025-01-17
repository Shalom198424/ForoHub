package foro.hub.domain.respuesta;


import foro.hub.domain.curso.CursoRepository;
import foro.hub.domain.usuarios.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespuestaService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    public DatosDetalleRespuesta datosDetalleRespuesta(Respuesta datos) throws ValidacionDeIntegridad {
        if (!usuarioRepository.findById(datos.idUsuario()).isPresent())
            throw new ValidacionDeIntegridad("Este ID de usuario no está registrado en la base de datos. ");
        if (!cursoRepository.findById(datos.idCurso()).isPresent()){
            throw new ValidacionDeIntegridad("Este id de curso no está registrado en la base de datos. ");
        }
        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var curso = cursoRepository.findById(datos.idCurso()).get();

        var datosRespuesta = new DatosRespuesta("Solucion",
                usuario.getId(),
                curso.getId(),
                LocalDateTime.now());

        var rVerified= new Respuesta(null,datosRespuesta.solucion(),usuario,curso,datosRespuesta.fecha());
        respuestaRepository.save(rVerified);
        return new DatosDetalleRespuesta(rVerified);
    }
    }
