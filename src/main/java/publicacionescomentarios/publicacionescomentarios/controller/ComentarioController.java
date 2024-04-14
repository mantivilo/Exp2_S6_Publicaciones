package publicacionescomentarios.publicacionescomentarios.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import publicacionescomentarios.publicacionescomentarios.model.Comentario;
import publicacionescomentarios.publicacionescomentarios.service.ComentarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;
    
    //http://localhost:8080/publicaciones
    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }

    //http://localhost:8080/publicaciones/1
    @GetMapping("/{id}")
    public Optional<Comentario> getComentarioById(@PathVariable Long id) {
        return comentarioService.getComentarioById(id);
    }
}

