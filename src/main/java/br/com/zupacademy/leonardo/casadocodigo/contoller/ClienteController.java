package br.com.zupacademy.leonardo.casadocodigo.contoller;

import br.com.zupacademy.leonardo.casadocodigo.dto.ClienteForm;
import br.com.zupacademy.leonardo.casadocodigo.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid ClienteForm form) {
        Cliente cliente = form.toModel(manager);
        manager.persist(cliente);

        return ResponseEntity.ok().build();
    }
}
