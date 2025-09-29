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

import uniandes.edu.co.proyecto.repositorio.UsuarioClienteRepository;
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;

@RestController
public class UsuariosClienteController {
    
    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @GetMapping("/usuariosCliente")
    public ResponseEntity<Collection<UsuarioCliente>> usuariosCliente(){
        try {
            Collection<UsuarioCliente> usuariosCliente = usuarioClienteRepository.getUsuariosCliente();
            return ResponseEntity.ok(usuariosCliente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
