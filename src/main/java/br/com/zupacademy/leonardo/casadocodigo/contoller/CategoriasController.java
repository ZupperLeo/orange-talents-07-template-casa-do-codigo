package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.CategoriaDTO;
import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;
import br.com.zupacademy.leonardo.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private ProibeNomeCategoriaRepetido proibeNomeCategoriaRepetido;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeNomeCategoriaRepetido);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> criarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {

        Categoria categoria = new Categoria(categoriaDTO.getNome());

        repository.save(categoria);

        return ResponseEntity.ok().build();
    }
}
