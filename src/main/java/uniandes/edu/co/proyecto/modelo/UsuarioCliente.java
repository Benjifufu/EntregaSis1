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

    public UsuarioCliente(){;}

    public UsuarioCliente(String nombre, String correo, String cedula, String celular) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.celular = celular;

    }

    public Long getIdUsuarioCliente() {
        return idUsuarioCliente;
    }

    public void setIdUsuarioCliente(Long idUsuarioCliente) {
        this.idUsuarioCliente = idUsuarioCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public List<TarjetaCredito> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaCredito> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
