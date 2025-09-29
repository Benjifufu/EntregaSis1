package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "relation_11")
@IdClass(Relation11PK.class)
public class Relation11PK {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @Id
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idRuta", insertable = false, updatable = false)
    private RutaServicio rutaServicio;

    @ManyToOne
    @JoinColumn(name = "direccion", insertable = false, updatable = false)
    private PuntoGeografico puntoGeografico;

    // Getters y setters
}
