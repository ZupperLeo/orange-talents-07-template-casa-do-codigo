package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.LivroForm;
import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastraNovoLivro(@RequestBody @Valid LivroForm form) {
        Livro livro = form.toModel(manager);
        manager.persist(livro);

        return ResponseEntity.ok().build();
    }
}
