package com.autentication.apirest.repository;

import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;
import com.autentication.apirest.services.ILibroService;

import java.util.List;
import java.util.Optional;

public interface IAuthorRepository {
    public Author createAuthor(Author autor);
    public boolean deleteAuthor(Long id);
    public Optional<Author> searchAuthor(Long id);
    public List<Author> listAuthores();
    public Author editAuthor(Long id, Author autor);
    public List<Libro> listLibrosFromAutor(Long id, ILibroService libroService);
}