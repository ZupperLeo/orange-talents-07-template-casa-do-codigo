package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.DetalhesLivroDTO;
import br.com.zupacademy.leonardo.casadocodigo.dto.LivroDTO;
import br.com.zupacademy.leonardo.casadocodigo.dto.LivroForm;
import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import br.com.zupacademy.leonardo.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private LivroRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastraNovoLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(manager);
        manager.persist(livro);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Transactional
    public List<LivroDTO> lista() {
        List<LivroDTO> livros = new ArrayList<>();

        repository.findAll().forEach(
                livro -> {
                    livros.add(new LivroDTO(livro));
                }
        );

        return livros;
    }

    @GetMapping(value = "/{id}")
    @TransactionScoped
    public ResponseEntity<DetalhesLivroDTO> detalhe(@PathVariable("id") Long id) {
        Optional<Livro> livro = repository.findById(id);
        if(livro.isPresent()) {
            return ResponseEntity.ok(new DetalhesLivroDTO((livro.get())));
        }

        return ResponseEntity.notFound().build();
    }

}
