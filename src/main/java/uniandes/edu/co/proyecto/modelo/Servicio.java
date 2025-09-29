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
@Table(name = "servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServicio;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String nivel;

    @Column(nullable = false)
    private double distancia;

    @Column(nullable = false)
    private double costoTotal;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFinal;

    @Column(nullable = false)
    private String duracion;

    private String nivelTransporte;
    private String ordenDomicilio;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCliente", nullable = false)
    private UsuarioCliente usuarioCliente;

    @ManyToOne
    @JoinColumn(name = "idUsuarioConductor", nullable = false)
    private UsuarioConductor usuarioConductor;

    // Getters y setters
}
