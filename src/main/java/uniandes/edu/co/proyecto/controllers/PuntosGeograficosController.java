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

import uniandes.edu.co.proyecto.repositorio.PuntoGeograficoRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
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

}
