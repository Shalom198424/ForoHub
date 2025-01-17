package foro.hub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Table(name = "cursos")
@Entity(name = "curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

    public class Curso {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String titulo;
        private String mensaje;
        private String creacion;
        @Enumerated(EnumType.STRING)
        private Estado estado;
        private String autor;
        private String curso;


    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.titulo = datosRegistroCurso.titulo();
        this.mensaje = datosRegistroCurso.mensaje();
        this.creacion = datosRegistroCurso.creacion();
        this.estado = datosRegistroCurso.estado();
        this.autor = datosRegistroCurso.autor();
        this.curso = datosRegistroCurso.curso();
    }
    public Curso() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarCurso datosActualizarCurso) {
        if (datosActualizarCurso.titulo() != null){
            this.titulo = datosActualizarCurso.titulo();
        }
        if (datosActualizarCurso.mensaje() != null){
            this.mensaje = datosActualizarCurso.mensaje();
        }
        if (datosActualizarCurso.creacion() != null){
            this.creacion = datosActualizarCurso.creacion();
        }
        if(datosActualizarCurso.estado() != null){
            this.estado = datosActualizarCurso.estado();
        }
        if(datosActualizarCurso.autor() != null){
            this.autor = datosActualizarCurso.autor();
        }
        if(datosActualizarCurso.curso() != null){
            this.curso = datosActualizarCurso.curso();
        }
    }

}