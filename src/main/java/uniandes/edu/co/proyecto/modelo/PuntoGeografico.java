package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntogeografico")
public class PuntoGeografico {

    @Id
    private String direccion;

    @Column(nullable = false)
    private double coordenadaX;

    @Column(nullable = false)
    private double coordenadaY;

    @ManyToOne
    @JoinColumn(name = "idCiudad", nullable = false)
    private Ciudad ciudad;


    public PuntoGeografico() {;}

    public PuntoGeografico(String direccion, double coordenadaX, double coordenadaY, Ciudad ciudad) {
        this.direccion = direccion;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
