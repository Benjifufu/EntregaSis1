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

import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.Servicio;

@RestController
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @GetMapping("/servicios")
    public ResponseEntity<Collection<Servicio>> servicios(){
        try {
            Collection<Servicio> servicios = servicioRepository.getServicios();
            return ResponseEntity.ok(servicios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/servicios/new/save")
    public ResponseEntity<String> servicioGuardar(@RequestBody Servicio servicio){
        try {
            servicioRepository.insertServicio(servicio.getTipo(), servicio.getNivel(), servicio.getDistancia(), servicio.getCostoTotal(), servicio.getDuracion(), servicio.getNivelTransporte(), servicio.getOrdenDomicilio(), servicio.getUsuarioCliente().getIdUsuarioCliente(), servicio.getUsuarioConductor().getIdUsuarioConductor(), servicio.getVehiculo().getPlaca(), servicio.getFechaInicio(), servicio.getFechaFinal());
            return new ResponseEntity<>("Servicio creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
