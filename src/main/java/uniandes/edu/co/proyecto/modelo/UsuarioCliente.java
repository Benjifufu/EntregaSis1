package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuariocliente")
public class UsuarioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioCliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String celular;

    @OneToMany(mappedBy = "usuarioCliente")
    private List<Revision> revisiones;

    @OneToMany(mappedBy = "usuarioCliente")
    private List<TarjetaCredito> tarjetas;

    @OneToMany(mappedBy = "usuarioCliente")
    private List<Servicio> servicios;

    // Getters y setters
}
