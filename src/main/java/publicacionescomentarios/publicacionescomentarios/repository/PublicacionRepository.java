package publicacionescomentarios.publicacionescomentarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import publicacionescomentarios.publicacionescomentarios.model.Publicacion;

public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
}
