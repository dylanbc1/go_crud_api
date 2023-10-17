package com.autentication.apirest.repository.impl;

import com.autentication.apirest.model.Libro;
import com.autentication.apirest.repository.ILibroRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LibroRepository implements ILibroRepository {
    private List<Libro> libros;

    // aqui no es necesario colocar @AllArgsConstructor, ya que no necesita
    // inyección de dependencias a causa de que NO depende de nadie, porque
    // esa instancia de libros la crea aca mismo, no es que se lo pasen
    // por parámetro sino que él mismo lo tiene y solo él lo usa
    public LibroRepository() {
        libros = new ArrayList<>();
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
    public Libro editLibro(Long id, Libro libro) {
        Libro existingLibro = searchLibro(id).orElse(null);
        if (existingLibro == null) {
            return null;
        } else {
            libros.remove(existingLibro);

            if (idIsRepeated(libro.getId())) {
                return null;
            }

            Libro newLibro = new Libro(libro.getId(), libro.getTitulo(), libro.getFechaPublicacion(), libro.getAutorId());
            libros.add(newLibro);
        }

        return libro;
    }
}
