package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import org.springframework.data.domain.Page;

import javax.validation.constraints.*;

public class LivroDTO {

    @NotNull
    private Long id;
    private String titulo;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static Page<LivroDTO> toModel(Page<Livro> livros) {
        return livros.map(LivroDTO::new);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
