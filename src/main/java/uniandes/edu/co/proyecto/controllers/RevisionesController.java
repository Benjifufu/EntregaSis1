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

import uniandes.edu.co.proyecto.repositorio.RevisionRepository;
import uniandes.edu.co.proyecto.modelo.Revision;

@RestController
public class RevisionesController {
    
    @Autowired
    private RevisionRepository revisionRepository;

    @GetMapping("/revisiones")
    public ResponseEntity<Collection<Revision>> revisiones(){
        try {
            Collection<Revision> revisiones = revisionRepository.getRevisiones();
            return ResponseEntity.ok(revisiones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/revisiones/new/save")
    public ResponseEntity<String> revisionGuardar(@RequestBody Revision revision){
        try {
            revisionRepository.insertRevision(revision.getCalificacion(), revision.getComentario(), revision.getRevisionServicioUsuario(), revision.getUsuarioCliente().getIdUsuarioCliente(), revision.getUsuarioConductor().getIdUsuarioConductor());
            return new ResponseEntity<>("Revision creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/revisiones/{id}/edit/save")
    public ResponseEntity<String> revisionEditar(@PathVariable Long id, @RequestBody Revision revision){
        try {
            revisionRepository.updateRevision(id, revision.getCalificacion(), revision.getComentario(), revision.getRevisionServicioUsuario(), revision.getUsuarioCliente().getIdUsuarioCliente(), revision.getUsuarioConductor().getIdUsuarioConductor());
            return new ResponseEntity<>("Revision editada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/revisiones/{id}/delete")
    public ResponseEntity<String> revisionEliminar(@PathVariable("id") Long id) {
        try {
            revisionRepository.deleteRevision(id);
            return new ResponseEntity<>("Revision eliminada exitosamente", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
}
