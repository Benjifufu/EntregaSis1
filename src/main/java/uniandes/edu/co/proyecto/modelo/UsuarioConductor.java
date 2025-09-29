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
@Table(name = "usuarioconductor")
public class UsuarioConductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioConductor;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String correo;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Revision> revisiones;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Servicio> servicios;

    // Getters y setters
}
