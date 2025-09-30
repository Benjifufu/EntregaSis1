package uniandes.edu.co.proyecto.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.VehiculoRepository;
import uniandes.edu.co.proyecto.modelo.Vehiculo;

@RestController
public class VehiculosController {
    
    @Autowired
    private VehiculoRepository vehiculoRepository; 

    @GetMapping("/vehiculos")
    public ResponseEntity<Collection<Vehiculo>> vehiculos(){
        try {
            Collection<Vehiculo> vehiculo = vehiculoRepository.getVehiculos();
            return ResponseEntity.ok(vehiculo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/vehiculos/new/save")
    public ResponseEntity<String> vehiculoGuardar(@RequestBody Vehiculo vehiculo){
        try {
            vehiculoRepository.insertVehiculo(vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getColor(), vehiculo.getCapacidad(), vehiculo.getCiudad().getIdCiudad(), vehiculo.getUsuarioConductor().getIdUsuarioConductor());
            return new ResponseEntity<>("usuario cliente creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/vehiculos/{id}/edit/save")
    public ResponseEntity<String> vehiculoEditar(@PathVariable String id, @RequestBody Vehiculo vehiculo){
        try {
            vehiculoRepository.updateVehiculo(vehiculo.getPlaca(), vehiculo.getTipo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getColor(), vehiculo.getCapacidad(), vehiculo.getCiudad().getIdCiudad(), vehiculo.getUsuarioConductor().getIdUsuarioConductor());
            return new ResponseEntity<>("vehiculo editado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/vehiculos/{id}/delete")
    public ResponseEntity<String> vehiculoEliminar(@PathVariable("id") String id) {
        try {
            vehiculoRepository.deleteVehiculo(id);
            return new ResponseEntity<>("vehiculo eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
