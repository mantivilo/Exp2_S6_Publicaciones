package publicacionescomentarios.publicacionescomentarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publicacionescomentarios.publicacionescomentarios.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
