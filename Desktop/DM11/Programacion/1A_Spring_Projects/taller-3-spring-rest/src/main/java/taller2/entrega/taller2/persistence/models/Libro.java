package taller2.entrega.taller2.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Libro {
    private Long id;
    private String titulo;
    private Date fechaPublicacion;
    private Autor autor;
}
