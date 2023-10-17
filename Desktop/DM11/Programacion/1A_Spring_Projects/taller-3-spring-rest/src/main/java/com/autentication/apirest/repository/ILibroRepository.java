package com.autentication.apirest.repository;

import com.autentication.apirest.model.Libro;

import java.util.List;
import java.util.Optional;

public interface ILibroRepository {
    public Libro createLibro(Libro libro);
    public boolean deleteLibro(Long id);
    public Optional<Libro> searchLibro(Long id);
    public List<Libro> listLibros();
    public Libro editLibro(Long id, Libro libro);
}
