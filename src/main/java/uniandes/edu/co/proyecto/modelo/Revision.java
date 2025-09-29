package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "revision")
public class Revision {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevision;

    @Column(nullable = false)
    private int calificacion;

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

    // Getters y setters
}
