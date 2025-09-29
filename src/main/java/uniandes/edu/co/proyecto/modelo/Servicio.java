package uniandes.edu.co.proyecto.modelo;

import java.sql.Timestamp;

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
    private Timestamp fechaInicio;

    @Column(nullable = false)
    private Timestamp fechaFinal;

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

    @ManyToOne
    @JoinColumn(name = "placa", nullable = false)
    private Vehiculo vehiculo;

    public Servicio() {;
    }

    public Servicio(String tipo, String nivel, double distancia, double costoTotal, Timestamp fechaInicio,
            Timestamp fechaFinal, String duracion, String nivelTransporte, String ordenDomicilio,
            UsuarioCliente usuarioCliente, UsuarioConductor usuarioConductor, Vehiculo vehiculo) {
        this.tipo = tipo;
        this.nivel = nivel;
        this.distancia = distancia;
        this.costoTotal = costoTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.duracion = duracion;
        this.nivelTransporte = nivelTransporte;
        this.ordenDomicilio = ordenDomicilio;
        this.usuarioCliente = usuarioCliente;
        this.usuarioConductor = usuarioConductor;
        this.vehiculo = vehiculo;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public double getDistancia() {
        return distancia;
    }
    
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Timestamp fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getNivelTransporte() {
        return nivelTransporte;
    }

    public void setNivelTransporte(String nivelTransporte) {
        this.nivelTransporte = nivelTransporte;
    }

    public String getOrdenDomicilio() {
        return ordenDomicilio;
    }

    public void setOrdenDomicilio(String ordenDomicilio) {
        this.ordenDomicilio = ordenDomicilio;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public UsuarioConductor getUsuarioConductor() {
        return usuarioConductor;
    }

    public void setUsuarioConductor(UsuarioConductor usuarioConductor) {
        this.usuarioConductor = usuarioConductor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
}
