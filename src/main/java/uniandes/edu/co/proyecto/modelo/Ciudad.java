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
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "ciudad")
    private List<PuntoGeografico> puntosGeograficos;

    // Getters y setters
}
