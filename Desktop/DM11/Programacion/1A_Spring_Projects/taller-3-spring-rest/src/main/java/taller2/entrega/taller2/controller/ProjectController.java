package taller2.entrega.taller2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import taller2.entrega.taller2.persistence.models.Autor;
import taller2.entrega.taller2.persistence.models.Libro;
import taller2.entrega.taller2.service.IProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProjectController {
    private IProjectService projectService;
    public ProjectController(IProjectService projectService){
        this.projectService = projectService;
    }

    // libros
    @PostMapping("/libros")
    public Libro createLibro(@RequestBody Libro libro){
        return this.projectService.createLibro(libro);
    }

    @GetMapping("/libros")
    public List<Libro> listLibros(){
        return this.projectService.listLibros();
    }

    @GetMapping("/libros/{id}")
    public Libro getLibroById(@PathVariable Long id){
        Optional<Libro> libro = this.projectService.searchLibro(id);

        return libro.orElse(null);
    }

    /*
    @PutMapping("/libros/{id}")
    public Libro editLibro(@PathVariable Long id, @RequestBody Libro libro){


        return this.projectService.editLibro()
    }*/

    @DeleteMapping("/libros/{id}")
    public boolean deleteLibro(@PathVariable Long id){
        return this.projectService.deleteLibro(id);
    }

    // autores
    @GetMapping("/autores")
    public List<Autor> listAllAuthors(){
        return this.projectService.listAutores();
    }

    @GetMapping("/autores/{id}")
    public Autor getAutorById(@PathVariable Long id){
        Optional<Autor> autor = this.projectService.searchAutor(id);

        return autor.orElse(null);
    }

    @PostMapping("/autores")
    public Autor createAutor(@RequestBody Autor autor) {
        return this.projectService.createAutor(autor);
    }

    @DeleteMapping("/autores/{id}")
    public boolean deleteAutor(@PathVariable Long id) {
        return this.projectService.deleteAutor(id);
    }

    @GetMapping("/autores/{id}/libros")
    public List<Libro> getLibrosFromAutor(@PathVariable Long id){
        return this.projectService.listLibrosFromAutor(id);
    }
}