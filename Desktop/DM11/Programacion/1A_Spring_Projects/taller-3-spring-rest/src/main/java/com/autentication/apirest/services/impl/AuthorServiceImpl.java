package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Author;
import com.autentication.apirest.model.Libro;
import com.autentication.apirest.repository.IAuthorRepository;
import com.autentication.apirest.services.IAuthorService;
import com.autentication.apirest.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    IAuthorRepository authorRepository;
    private ILibroService libroService;

    @Autowired
    public AuthorServiceImpl(IAuthorRepository authorRepository, ILibroService libroService) {
        this.authorRepository = authorRepository;
        this.libroService = libroService;
    }

    @Override
    public Author createAuthor(Author Author) {
        return authorRepository.createAuthor(Author);
    }

    @Override
    public boolean deleteAuthor(Long id) {
        return authorRepository.deleteAuthor(id);
    }

    @Override
    public Optional<Author> searchAuthor(Long id) {
        return authorRepository.searchAuthor(id);
    }

    @Override
    public List<Author> listAuthores() {
        return authorRepository.listAuthores();
    }

    @Override
    public Author editAuthor(Long id, Author Author) {
        return authorRepository.editAuthor(id, Author);
    }

    @Override
    public List<Libro> listLibrosFromAutor(Long id) {
        return authorRepository.listLibrosFromAutor(id, libroService);
    }
}
