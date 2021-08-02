package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.EstadoForm;
import br.com.zupacademy.leonardo.casadocodigo.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> cadastrar(@RequestBody @Valid EstadoForm form) {
        Estado estado = form.toModel(manager);
        manager.persist(estado);

        return ResponseEntity.ok().build();
    }
}
