package foro.hub.domain.respuesta;

import foro.hub.domain.curso.Curso;
import foro.hub.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String solucion;
    @OneToOne
    @JoinColumn(name="autor_id")
    private Usuario autor;
    @OneToOne
    @JoinColumn(name="curso_id")
    private Curso curso;
    private boolean activo;

    public Respuesta() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Respuesta(Long id, String solucion, Usuario usuario, Curso curso, LocalDateTime fecha) {
        this.id=id;
        this.solucion=solucion;
        this.autor=usuario;
        this.curso=curso;
        this.fecha=LocalDateTime.now();
    }

    public void respuestaActualizada(RespuestaActualizada respuestaActualizada) {
        if (respuestaActualizada.solucion() != null){
            this.solucion=respuestaActualizada.solucion();
        }
    }
    public void diactivateResponse(){

        this.activo=false;
    }

    public Long idUsuario() {
        return 0L;
    }

    public Long idCurso() {

        return 0L;
    }

}