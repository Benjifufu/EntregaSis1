package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tarjetacredito")
public class TarjetaCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @Column(nullable = false)
    private String nombreTarjeta;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @Column(nullable = false)
    private int codigoSeguridad;

    @ManyToOne
    @JoinColumn(name = "idUsuarioCliente", nullable = false)
    private UsuarioCliente usuarioCliente;

    // Getters y setters
}
