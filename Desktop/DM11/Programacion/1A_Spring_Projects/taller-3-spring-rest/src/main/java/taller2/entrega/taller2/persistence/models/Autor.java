package taller2.entrega.taller2.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Autor {
    private Long id;
    private String nombre;
    private String nacionalidad;
}
