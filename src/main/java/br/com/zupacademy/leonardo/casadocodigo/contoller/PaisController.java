package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.PaisForm;
import br.com.zupacademy.leonardo.casadocodigo.model.Pais;
import br.com.zupacademy.leonardo.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> cadastrar(@RequestBody @Valid PaisForm form) {
        Pais pais = new Pais(form.getNome());
        repository.save(pais);

        return ResponseEntity.ok().build();
    }
}
