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

import uniandes.edu.co.proyecto.repositorio.UsuarioConductorRepository;
import uniandes.edu.co.proyecto.modelo.UsuarioConductor;

@RestController
public class UsuariosConductorController {

    @Autowired
    private UsuarioConductorRepository usuarioConductorRepository;

    @GetMapping("/usuariosConductor")
    public ResponseEntity<Collection<UsuarioConductor>> usuariosConductor(){
        try {
            Collection<UsuarioConductor> usuarioConductor = usuarioConductorRepository.getUsuariosConductor();
            return ResponseEntity.ok(usuarioConductor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/usuarioConductor/new/save")
    public ResponseEntity<String> usuarioConductorGuardar(@RequestBody UsuarioConductor usuarioConductor){
        try {
            usuarioConductorRepository.insertUsuarioConductor(usuarioConductor.getNombre(), usuarioConductor.getCorreo(), usuarioConductor.getCedula(), usuarioConductor.getCelular());
            return new ResponseEntity<>("usuario conductor creado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PostMapping("/usuarioConductor/{id}/edit/save")
    public ResponseEntity<String> usuarioConductorEditar(@PathVariable Long id, @RequestBody UsuarioConductor usuarioConductor){
        try {
            usuarioConductorRepository.updateUsuarioConductor(id, usuarioConductor.getNombre(), usuarioConductor.getCorreo(), usuarioConductor.getCedula(), usuarioConductor.getCelular());
            return new ResponseEntity<>("usuario conductor editado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/usuarioConductor/{id}/delete")
    public ResponseEntity<String> usuarioConductorEliminar(@PathVariable("id") Long id) {
        try {
            usuarioConductorRepository.deleteUsuarioConductor(id);
            return new ResponseEntity<>("usuario conductor eliminado exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
