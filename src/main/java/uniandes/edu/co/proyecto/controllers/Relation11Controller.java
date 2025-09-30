package uniandes.edu.co.proyecto.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.Relation11Repository;
import uniandes.edu.co.proyecto.modelo.Relation11;


@RestController
public class Relation11Controller {
    
    @Autowired
    private Relation11Repository relation11Repository;
    
    @GetMapping("/relation11")
    public ResponseEntity<Collection<Relation11>> relation11(){
        try {
            Collection<Relation11> relation11 = relation11Repository.getRelations11();
            return ResponseEntity.ok(relation11);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/relation11/new/save")
    public ResponseEntity<String> relation11Guardar(@RequestBody Relation11 relation11){
        try {
            relation11Repository.insertRelation11(relation11.getPk().getIdRuta(), relation11.getPk().getDireccion());
            return new ResponseEntity<>("relation11 creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
