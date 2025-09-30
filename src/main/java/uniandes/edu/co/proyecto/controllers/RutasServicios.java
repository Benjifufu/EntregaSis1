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

import uniandes.edu.co.proyecto.repositorio.RutaServicioRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.RutaServicio;

@RestController
public class RutasServicios {
    
    @Autowired 
    private RutaServicioRepository rutaServicioRepository;

    @GetMapping("/rutasServicios")
    public ResponseEntity<Collection<RutaServicio>> rutasServicios(){
        try {
            Collection<RutaServicio> rutaServicios = rutaServicioRepository.getRutasServicios();
            return ResponseEntity.ok(rutaServicios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/rutasServicio/new/save")
    public ResponseEntity<String> rutaServicioGuardar(@RequestBody RutaServicio rutaServicio){
        try {
            rutaServicioRepository.insertRutaServicio(rutaServicio.getIdRuta(), rutaServicio.getServicio().getIdServicio());
            return new ResponseEntity<>("Ruta Servicio creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
