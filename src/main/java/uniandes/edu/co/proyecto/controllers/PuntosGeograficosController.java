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

import uniandes.edu.co.proyecto.repositorio.PuntoGeograficoRepository;
import uniandes.edu.co.proyecto.modelo.PuntoGeografico;

@RestController
public class PuntosGeograficosController {
    
    @Autowired
    private PuntoGeograficoRepository puntosGeograficosRepository;

    @GetMapping("/puntosGeograficos")
    public ResponseEntity<Collection<PuntoGeografico>> puntosGeograficos(){
        try {
            Collection<PuntoGeografico> puntosGeograficos = puntosGeograficosRepository.getPuntosGeograficos();
            return ResponseEntity.ok(puntosGeograficos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/puntosGeograficos/new/save")
    public ResponseEntity<String> puntoGeograficoGuardar(@RequestBody PuntoGeografico puntoGeografico){
        try {
            puntosGeograficosRepository.insertPuntoGeografico(puntoGeografico.getCoordenadaX(), puntoGeografico.getDireccion(), puntoGeografico.getCoordenadaY(), puntoGeografico.getCiudad().getIdCiudad());
            return new ResponseEntity<>("Punto Geografico creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/puntosGeograficos/{id}/edit/save")
    public ResponseEntity<String> puntoGeograficoEditar(@PathVariable Long id, @RequestBody PuntoGeografico puntoGeografico){
        try {
            puntosGeograficosRepository.updatePuntoGeografico(id, puntoGeografico.getDireccion(),puntoGeografico.getCoordenadaX(), puntoGeografico.getCoordenadaY());
            return new ResponseEntity<>("Punto Geografico editada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/puntosGeograficos/{id}/delete")
    public ResponseEntity<String> puntoGeograficoEliminar(@PathVariable String direccion) {
        try {
            puntosGeograficosRepository.deletePuntoGeografico(direccion);
            return new ResponseEntity<>("Punto Geografico eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
