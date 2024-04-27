package publicacionescomentarios.publicacionescomentarios.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import publicacionescomentarios.publicacionescomentarios.model.Publicacion;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PublicacionRepositoryTest {

    @Autowired
    private PublicacionRepository publicacionRepository;

    //simulamos una publicación y le daremos la descripción Publicación test
    @Test
    public void guardarPublicacionTest() {
        Publicacion publicacion = new Publicacion();
        publicacion.setDescPublicacion("Publicacion test");

        Publicacion resultado = publicacionRepository.save(publicacion);

        assertNotNull(resultado.getIdPublicacion());
        assertEquals("Publicacion test", resultado.getDescPublicacion());//lo que espero es que venga: Publicacion test cuando haga un get
    }
    
}
