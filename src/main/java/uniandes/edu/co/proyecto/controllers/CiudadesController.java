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

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;


@RestController
public class CiudadesController {

    @Autowired
    private CiudadRepository ciudadRepository;
    
    @GetMapping("/ciudades")
    public ResponseEntity<Collection<Ciudad>> ciudades(){
        try {
            Collection<Ciudad> ciudades = ciudadRepository.getCiudades();
            return ResponseEntity.ok(ciudades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody Ciudad ciudad){
        try {
            ciudadRepository.insertCiudad(ciudad.getDepartamento(), ciudad.getNombre());
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/ciudades/{id}/edit/save")
    public ResponseEntity<String> ciudadEditar(@PathVariable Long id, @RequestBody Ciudad ciudad){
        try {
            ciudadRepository.updateCiudad(id, ciudad.getDepartamento(), ciudad.getNombre());
            return new ResponseEntity<>("Ciudad editada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/ciudades/{id}/delete")
    public ResponseEntity<String> ciudadEliminar(@PathVariable("id") Long id) {
        try {
            ciudadRepository.deleteCiudad(id);
            return new ResponseEntity<>("Ciudad eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}


