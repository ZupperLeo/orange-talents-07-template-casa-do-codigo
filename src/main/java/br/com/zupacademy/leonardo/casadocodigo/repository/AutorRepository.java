package br.com.zupacademy.leonardo.casadocodigo.repository;

import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    String findByNome(String nome);
}
