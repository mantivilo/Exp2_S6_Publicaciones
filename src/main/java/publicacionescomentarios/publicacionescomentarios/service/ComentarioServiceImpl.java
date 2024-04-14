package publicacionescomentarios.publicacionescomentarios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import publicacionescomentarios.publicacionescomentarios.model.Comentario;
import publicacionescomentarios.publicacionescomentarios.repository.ComentarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }
   
    @Override
    public Optional<Comentario> getComentarioById(Long id) {
        return comentarioRepository.findById(id);
    }
}
