package publicacionescomentarios.publicacionescomentarios.service;

import publicacionescomentarios.publicacionescomentarios.model.Publicacion;
import java.util.List;
import java.util.Optional;

public interface PublicacionService {
    List<Publicacion> getAllPublicaciones();
    Optional<Publicacion> getPublicacionById(Long id);
    Publicacion createPublicacion (Publicacion publicacion);
    Publicacion updatePublicacion(Long id, Publicacion publicacion);
    void deletePublicacion(Long id);
}