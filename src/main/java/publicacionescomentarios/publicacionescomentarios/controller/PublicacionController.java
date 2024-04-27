package publicacionescomentarios.publicacionescomentarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import publicacionescomentarios.publicacionescomentarios.model.Publicacion;
import publicacionescomentarios.publicacionescomentarios.service.PublicacionService;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    private static final Logger log = LoggerFactory.getLogger(PublicacionController.class);

    @Autowired
    private PublicacionService publicacionService;

    //http://localhost:8080/publicaciones
    /*@GetMapping
    public List<Publicacion> getAllPublicaciones(){
        return publicacionService.getAllPublicaciones();
    }*/

    @GetMapping
    public CollectionModel<EntityModel<Publicacion>> getAllPublicaciones() {
        List<Publicacion> publicaciones = publicacionService.getAllPublicaciones();
        log.info("GET /publicaciones");
        log.info("Retornando todos las publicaciones");
        List<EntityModel<Publicacion>> publicacionesResources = publicaciones.stream()
            .map( publicacion -> EntityModel.of(publicacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(publicacion.getIdPublicacion())).withSelfRel()
            ))
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicaciones());
        CollectionModel<EntityModel<Publicacion>> resources = CollectionModel.of(publicacionesResources, linkTo.withRel("publicaciones"));

        return resources;
    }
    
    //http://localhost:8080/publicaciones/1
    /*@GetMapping("/{id}")
    public Optional<Publicacion> getPublicacionById(@PathVariable Long id) {
        return publicacionService.getPublicacionById(id);
    }*/

    @GetMapping("/{id}")
    public EntityModel<Publicacion> getPublicacionById(@PathVariable Long id) {
        Optional<Publicacion> publicacion = publicacionService.getPublicacionById(id);

        if (publicacion.isPresent()) {
            return EntityModel.of(publicacion.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicaciones()).withRel("all-publicaciones"));
        } else {
            throw new PublicacionNotFoundException("Post not found with id: " + id);
        }
    }

    /*@PostMapping
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }*/

    @PostMapping
    public EntityModel<Publicacion> createPublicacion(@Validated @RequestBody Publicacion publicacion) {
        Publicacion createdPublicacion = publicacionService.createPublicacion(publicacion);
            return EntityModel.of(createdPublicacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(createdPublicacion.getIdPublicacion())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicaciones()).withRel("all-publicaciones"));

    }

    /*@PutMapping("/{id}")
    public Publicacion updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        return publicacionService.updatePublicacion(id, publicacion);
    }*/

    @PutMapping("/{id}")
    public EntityModel<Publicacion> updatePublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
        Publicacion updatedPublicacion = publicacionService.updatePublicacion(id, publicacion);
        return EntityModel.of(updatedPublicacion,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getPublicacionById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllPublicaciones()).withRel("all-publicaciones"));
    }

    @DeleteMapping("/{id}")
    public void deletePublicacion(@PathVariable Long id){
        publicacionService.deletePublicacion(id);
    }

    

}