package br.com.zupacademy.leonardo.casadocodigo.repository;

import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Page<Livro> findByTitulo(String titulo, Pageable paginacao);
}
