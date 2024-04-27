package publicacionescomentarios.publicacionescomentarios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import publicacionescomentarios.publicacionescomentarios.model.Publicacion;
import publicacionescomentarios.publicacionescomentarios.repository.PublicacionRepository;

@ExtendWith(MockitoExtension.class)
public class PublicacionServiceTest {
    @InjectMocks
    private PublicacionServiceImpl publicacionServicio;

    @Mock
    private PublicacionRepository publicacionRepositoryMock;

    @Test
    public void guardarPublicacionTest() {

        Publicacion publicacion = new Publicacion();
        publicacion.setDescPublicacion("Descripcion test");

        when(publicacionRepositoryMock.save(any())).thenReturn(publicacion);

        Publicacion resultado = publicacionServicio.createPublicacion(publicacion);

        assertEquals("Descripcion test", resultado.getDescPublicacion());
    }
}
