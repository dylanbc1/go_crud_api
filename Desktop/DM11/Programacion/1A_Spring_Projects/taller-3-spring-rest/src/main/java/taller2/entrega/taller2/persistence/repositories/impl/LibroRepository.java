package taller2.entrega.taller2.persistence.repositories.impl;

import org.springframework.stereotype.Repository;
import taller2.entrega.taller2.persistence.models.Autor;
import taller2.entrega.taller2.persistence.models.Libro;
import taller2.entrega.taller2.persistence.repositories.ILibroRepository;
import taller2.entrega.taller2.persistence.repositories.ILibroRepository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Repository
public class LibroRepository implements ILibroRepository {
    private List<Libro> libros;
    private List<Autor> autores;

    // aqui no es necesario colocar @AllArgsConstructor, ya que no necesita
    // inyección de dependencias a causa de que NO depende de nadie, porque
    // esa instancia de libros la crea aca mismo, no es que se lo pasen
    // por parámetro sino que él mismo lo tiene y solo él lo usa
    public LibroRepository() {
        libros = new ArrayList<>();
        autores = new ArrayList<>();
    }

    public boolean idIsRepeated(Long id) {
        Libro existingLibro = searchLibro(id).orElse(null);
        return existingLibro != null;
    }

    @Override
    public Libro createLibro(Libro libro) {
        Libro existingLibro = searchLibro(libro.getId()).orElse(null);
        if (existingLibro == null) {
            libros.add(libro);
        } else {
            return null;
        }

        return libro;
    }

    // logger no debe ir aqui en repo, aqui debemos retornar objetos o booleanos
    // para que service los retorne y haga lo necesario en controller

    @Override
    public boolean deleteLibro(Long id) {
        int i = searchI(id);

        if (i >= 0) {
            libros.remove(searchI(id));
            return true;
        }
        return false;
    }

    public int searchI(Long id) {
        int i = 0;
        for (Libro l : libros) {
            if (l.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public Optional<Libro> searchLibro(Long id) {
        return libros.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public List<Libro> listLibros() {
        return libros;
    }

    @Override
    public Libro editLibro(Libro libro) {
        Libro existingLibro = searchLibro(libro.getId()).orElse(null);
        if (existingLibro == null) {
            return null;
        } else {
            libros.remove(existingLibro);

            if (idIsRepeated(libro.getId())) {
                return null;
            }

            Libro newLibro = new Libro(libro.getId(), libro.getTitulo(), libro.getFechaPublicacion(), libro.getAutor());
            libros.add(newLibro);
        }

        return libro;
    }

    // autor
    @Override
    public Autor createAutor(Autor autor) {
        Libro existingAutor = searchLibro(autor.getId()).orElse(null);
        if (existingAutor == null) {
            autores.add(autor);
        } else {
            return null;
        }

        return autor;
    }

    @Override
    public boolean deleteAutor(Long id) {
        int i = searchIAutor(id);

        if (i >= 0) {
            autores.remove(searchI(id));
            return true;
        }
        return false;
    }

    public int searchIAutor(Long id) {
        int i = 0;
        for (Autor a : autores) {
            if (a.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public Optional<Autor> searchAutor(Long id) {
        return autores.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public List<Autor> listAutores() {
        return autores;
    }

    @Override
    public Autor editAutor(Autor autor) {
        Autor existingAutor = searchAutor(autor.getId()).orElse(null);
        if (existingAutor == null) {
            return null;
        } else {
            autores.remove(existingAutor);

            if (idIsRepeated(autor.getId())) {
                return null;
            }

            Autor newAutor = new Autor(autor.getId(), autor.getNombre(), autor.getNacionalidad());
            autores.add(newAutor);
        }

        return autor;
    }

    @Override
    public List<Libro> listLibrosFromAutor(Long id) {
        List<Libro> librosFromAutor = new ArrayList<>();

        if (searchAutor(id).isPresent()) {
            for (Libro l :
                    libros) {
                if (l.getAutor().equals(searchAutor(id).get())) {
                    librosFromAutor.add(l);
                }
            }
        } else {
            return null;
        }
        return librosFromAutor;
    }
}