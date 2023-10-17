package taller2.entrega.taller2.persistence.repositories;

import taller2.entrega.taller2.persistence.models.Autor;
import taller2.entrega.taller2.persistence.models.Libro;

import java.util.List;
import java.util.Optional;
import java.util.Optional;

public interface ILibroRepository {
    public Libro createLibro(Libro libro);
    public boolean deleteLibro(Long id);
    public Optional<Libro> searchLibro(Long id);
    public List<Libro> listLibros();
    public Libro editLibro(Libro libro);
    public Autor createAutor(Autor autor);
    public boolean deleteAutor(Long id);
    public Optional<Autor> searchAutor(Long id);
    public List<Autor> listAutores();
    public Autor editAutor(Autor autor);
    public List<Libro> listLibrosFromAutor(Long id);
}
