package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "revision")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevision;

    @Column(nullable = false)
    private long calificacion;

    @Column(nullable = false, length = 500)
    private String comentario;

    @Column(nullable = false, length = 100)
    private String revisionServicioUsuario;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCliente", nullable = false)
    private UsuarioCliente usuarioCliente;

    @ManyToOne
    @JoinColumn(name = "idUsuarioConductor", nullable = false)
    private UsuarioConductor usuarioConductor;

    public Revision() {;
    }   

    public Revision(long calificacion, String comentario, String revisionServicioUsuario, UsuarioCliente usuarioCliente, UsuarioConductor usuarioConductor) {
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.revisionServicioUsuario = revisionServicioUsuario;
        this.usuarioCliente = usuarioCliente;
        this.usuarioConductor = usuarioConductor;
    }

    public Long getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Long idRevision) {
        this.idRevision = idRevision;
    }

    public long getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getRevisionServicioUsuario() {
        return revisionServicioUsuario;
    }

    public void setRevisionServicioUsuario(String revisionServicioUsuario) {
        this.revisionServicioUsuario = revisionServicioUsuario;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }   

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public UsuarioConductor getUsuarioConductor() {
        return usuarioConductor;
    }
    public void setUsuarioConductor(UsuarioConductor usuarioConductor) {
        this.usuarioConductor = usuarioConductor;
    }

}
