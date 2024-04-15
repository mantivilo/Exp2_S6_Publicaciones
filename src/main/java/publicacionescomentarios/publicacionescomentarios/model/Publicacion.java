package publicacionescomentarios.publicacionescomentarios.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PUBLICACION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publicacion_seq")
    @SequenceGenerator(name = "publicacion_seq", sequenceName = "publicacion_seq", allocationSize = 1)
    @Column(name = "ID_PUBLICACION")
    private Long idPublicacion;

    @Column(name = "DESC_PUBLICACION")
    private String descPublicacion;

    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonIgnoreProperties("publicacion")
    private List<Comentario> comentarios;

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getDescPublicacion() {
        return descPublicacion;
    }

    public void setDescPublicacion(String descPublicacion) {
        this.descPublicacion = descPublicacion;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}

