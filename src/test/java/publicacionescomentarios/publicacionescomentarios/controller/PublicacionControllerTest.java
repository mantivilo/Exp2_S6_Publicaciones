package publicacionescomentarios.publicacionescomentarios.controller;

import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import publicacionescomentarios.publicacionescomentarios.model.Publicacion;
import publicacionescomentarios.publicacionescomentarios.service.PublicacionServiceImpl;

@WebMvcTest(PublicacionController.class)
public class PublicacionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublicacionServiceImpl publicacionServicioMock;

    private List<Publicacion> publicacions;

    @BeforeEach
    public void setUp() {
        Publicacion publicacion1 = new Publicacion();
        publicacion1.setDescPublicacion("Cancelada");
        publicacion1.setIdPublicacion(1L);
        Publicacion publicacion2 = new Publicacion();
        publicacion2.setDescPublicacion("Pendiente");
        publicacion2.setIdPublicacion(2L);
        publicacions = Arrays.asList(publicacion1, publicacion2);
    }

    @AfterEach
    public void tearDown() {
        publicacions = null;
    }

    @Test
    public void obtenerTodosTest() throws Exception {
        when(publicacionServicioMock.getAllPublicaciones()).thenReturn(publicacions);

        mockMvc.perform(MockMvcRequestBuilders.get("/publicaciones"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[0].descPublicacion", Matchers.is("Cancelada")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.publicacionList[1].descPublicacion", Matchers.is("Pendiente")));
    }
    
}
