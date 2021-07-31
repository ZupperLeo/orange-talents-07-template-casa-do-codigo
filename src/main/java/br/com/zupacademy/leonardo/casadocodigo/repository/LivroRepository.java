package br.com.zupacademy.leonardo.casadocodigo.repository;

import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
