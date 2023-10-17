package com.autentication.apirest.model;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Libro {
    private Long id;
    private String titulo;
    private Date fechaPublicacion;
    private Long autorId;
}
