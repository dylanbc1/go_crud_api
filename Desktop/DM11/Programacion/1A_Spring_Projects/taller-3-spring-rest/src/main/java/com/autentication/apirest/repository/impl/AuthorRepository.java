package com.autentication.apirest.repository.impl;

import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;
import com.autentication.apirest.repository.IAuthorRepository;
import com.autentication.apirest.repository.ILibroRepository;
import com.autentication.apirest.services.ILibroService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements IAuthorRepository {
    private List<Author> authores;

    public AuthorRepository(){
        authores = new ArrayList<>();
    }

    @Override
    public Author createAuthor(Author Author) {
        Author existingAuthor = searchAuthor(Author.getId()).orElse(null);
        if (existingAuthor == null) {
            authores.add(Author);
        } else {
            return null;
        }

        return Author;
    }

    @Override
    public boolean deleteAuthor(Long id) {
        int i = searchIAuthor(id);

        if (i >= 0) {
            authores.remove(searchI(id));
            return true;
        }
        return false;
    }

    public int searchI(Long id) {
        int i = 0;
        for (Author a : authores) {
            if (a.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int searchIAuthor(Long id) {
        int i = 0;
        for (Author a : authores) {
            if (a.getId().equals(id)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public Optional<Author> searchAuthor(Long id) {
        return authores.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public List<Author> listAuthores() {
        return authores;
    }

    @Override
    public Author editAuthor(Long id, Author Author) {
        Author existingAuthor = searchAuthor(id).orElse(null);
        if (existingAuthor == null) {
            return null;
        } else {
            authores.remove(existingAuthor);

            if (idIsRepeated(Author.getId())) {
                return null;
            }

            Author newAuthor = new Author(Author.getId(), Author.getNombre(), Author.getNacionalidad());
            authores.add(newAuthor);
        }

        return Author;
    }

    public boolean idIsRepeated(Long id) {
        Author existingLibro = searchAuthor(id).orElse(null);
        return existingLibro != null;
    }

    @Override
    public List<Libro> listLibrosFromAutor(Long id, ILibroService libroService) {
        List<Libro> librosFromAutor = new ArrayList<>();

        if (searchAuthor(id).isPresent()) {
            for (Libro l :
                    libroService.listLibros()) {
                if (l.getAutorId().equals(id)) {
                    librosFromAutor.add(l);
                }
            }
        } else {
            return null;
        }
        return librosFromAutor;
    }
}
