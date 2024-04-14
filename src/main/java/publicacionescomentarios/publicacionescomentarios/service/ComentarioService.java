package publicacionescomentarios.publicacionescomentarios.service;

import publicacionescomentarios.publicacionescomentarios.model.Comentario;
import java.util.List;
import java.util.Optional;

public interface ComentarioService {
    List<Comentario> getAllComentarios();
    Optional<Comentario> getComentarioById(Long id);
}