package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    private String placa;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "idCiudad", nullable = false)
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "idUsuarioConductor", nullable = false)
    private UsuarioConductor usuarioConductor;

    public Vehiculo() {;}

    public Vehiculo(String placa, String tipo, String marca, String modelo, String color, int capacidad, Ciudad ciudad, UsuarioConductor usuarioConductor) {
        this.placa = placa;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.capacidad = capacidad;
        this.ciudad = ciudad;
        this.usuarioConductor = usuarioConductor;
    }

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public UsuarioConductor getUsuarioConductor() {
        return usuarioConductor;
    }

    public void setUsuarioConductor(UsuarioConductor usuarioConductor) {
        this.usuarioConductor = usuarioConductor;
    }

}
