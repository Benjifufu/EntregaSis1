package uniandes.edu.co.proyecto.controllers;

import java.util.Collection;
import java.util.Date;

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

    @PostMapping("/servicios/{id}/edit/save")
    public ResponseEntity<String> servicioEditar(@PathVariable Long id, @RequestBody Servicio servicio){
        try {
            servicioRepository.updateServicio(servicio.getTipo(), servicio.getNivel(), servicio.getDistancia(), servicio.getCostoTotal(), servicio.getDuracion(), servicio.getNivelTransporte(), servicio.getOrdenDomicilio(), servicio.getUsuarioCliente().getIdUsuarioCliente(), servicio.getUsuarioConductor().getIdUsuarioConductor(), servicio.getVehiculo().getPlaca(), servicio.getFechaInicio(), servicio.getFechaFinal());
            return new ResponseEntity<>("Servicio editado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/servicios/{id}/delete")
    public ResponseEntity<String> servicioEliminar(@PathVariable("id") Long id) {
        try {
            servicioRepository.deleteServicio(id);
            return new ResponseEntity<>("Servicio eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/servicios/cliente/{id}")
    public ResponseEntity<Collection<Servicio>> serviciosPorCliente(@PathVariable("id") Long id) {
        try {
            Collection<Servicio> servicios = servicioRepository.getServiciosByCliente(id);
            if (servicios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(servicios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/servicios/reporte/bogota")
    public ResponseEntity<Collection<Servicio>> reporteServiciosBogotaPorFecha(
            @RequestParam("fechaInicio") Date fechaInicio,
            @RequestParam("fechaFin") Date fechaFin) {
        try {
            Collection<Servicio> reporte = servicioRepository.getReporteServiciosBogotaPorFecha(fechaInicio, fechaFin);
            if (reporte.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
