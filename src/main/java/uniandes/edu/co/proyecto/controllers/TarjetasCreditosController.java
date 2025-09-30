package uniandes.edu.co.proyecto.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.TarjetaCreditoRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.RutaServicio;
import uniandes.edu.co.proyecto.modelo.TarjetaCredito;

@RestController
public class TarjetasCreditosController {
    
    @Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    @GetMapping("/tarjetasCredito")
    public ResponseEntity<Collection<TarjetaCredito>> tarjetasCredito(){
        try {
            Collection<TarjetaCredito> tarjetasCredito = tarjetaCreditoRepository.getTarjetasCredito();
            return ResponseEntity.ok(tarjetasCredito);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/tarjetasCredito/new/save")
    public ResponseEntity<String> tarjetaCreditoGuardar(@RequestBody TarjetaCredito tarjetaCredito){
        try {
            tarjetaCreditoRepository.insertTarjetaCredito(tarjetaCredito.getNumero(), tarjetaCredito.getNombreTarjeta(), tarjetaCredito.getFechaVencimiento(), tarjetaCredito.getCodigoSeguridad(), tarjetaCredito.getUsuarioCliente().getIdUsuarioCliente());
            return new ResponseEntity<>("Tarjeta de credito creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
