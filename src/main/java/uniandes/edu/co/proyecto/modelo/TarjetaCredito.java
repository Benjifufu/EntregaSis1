package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private int numero;

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

    public TarjetaCredito() {;}

    public TarjetaCredito(int numero, String nombreTarjeta, Date fechaVencimiento, int codigoSeguridad, UsuarioCliente usuarioCliente) {
        this.numero = numero;
        this.nombreTarjeta = nombreTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.usuarioCliente = usuarioCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
 
    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public UsuarioCliente getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }
}
