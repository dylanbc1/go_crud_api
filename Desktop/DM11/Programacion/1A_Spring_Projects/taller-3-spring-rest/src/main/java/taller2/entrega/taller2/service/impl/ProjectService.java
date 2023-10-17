package taller2.entrega.taller2.service.impl;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import taller2.entrega.taller2.persistence.models.Autor;
import taller2.entrega.taller2.persistence.models.Libro;
import taller2.entrega.taller2.persistence.repositories.ILibroRepository;
import taller2.entrega.taller2.persistence.repositories.impl.LibroRepository;
import taller2.entrega.taller2.service.IProjectService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService implements IProjectService {
    private static Logger log = LoggerFactory.getLogger(Libro.class);

    private ILibroRepository iRepository;

    @Override
    public Libro createLibro(Libro libro) {
        return iRepository.createLibro(libro);
    }

    @Override
    public boolean deleteLibro(Long id) {
        return iRepository.deleteLibro(id);
    }

    @Override
    public Optional<Libro> searchLibro(Long id) {
        return iRepository.searchLibro(id);
    }

    @Override
    public List<Libro> listLibros(){
        return iRepository.listLibros();
    }

    @Override
    public Libro editLibro(Libro libro){
        return iRepository.editLibro(libro);
    }


    // autor
    @Override
    public Autor createAutor(Autor autor) {
        return iRepository.createAutor(autor);
    }

    @Override
    public boolean deleteAutor(Long id) {
        return iRepository.deleteAutor(id);
    }

    @Override
    public Optional<Autor> searchAutor(Long id) {
        return iRepository.searchAutor(id);
    }

    @Override
    public List<Autor> listAutores() {
        return iRepository.listAutores();
    }

    @Override
    public Autor editAutor(Autor autor) {
        return iRepository.editAutor(autor);
    }

    @Override
    public List<Libro> listLibrosFromAutor(Long id) {
        return iRepository.listLibrosFromAutor(id);
    }
}
