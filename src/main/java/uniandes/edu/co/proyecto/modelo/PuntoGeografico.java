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
@Table(name = "puntogeografico")
public class PuntoGeografico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String direccion;

    @Column(nullable = false)
    private double coordenadaX;

    @Column(nullable = false)
    private double coordenadaY;

    @ManyToOne
    @JoinColumn(name = "idCiudad", nullable = false)
    private Ciudad ciudad;

    // Getters y setters
}
