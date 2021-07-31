package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;
import br.com.zupacademy.leonardo.casadocodigo.model.Livro;
import br.com.zupacademy.leonardo.casadocodigo.repository.LivroRepository;
import br.com.zupacademy.leonardo.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LivroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Lob
    private String sumario;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private Integer totalPaginas;
    @NotNull
    @Future
    @JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dataLancamento;
    @NotNull
    private Long autorId;
    @NotNull
    private Long categoriaId;

    public LivroForm(@NotBlank String titulo, @NotBlank String sumario, @NotBlank String isbn,
                     @NotBlank @Size(max = 500) String resumo, @NotNull @Min(20) BigDecimal preco,
                     @NotNull @Min(100) Integer totalPaginas, @NotNull Long autorId, @NotNull Long categoriaId) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.resumo = resumo;
        this.preco = preco;
        this.totalPaginas = totalPaginas;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
    }

    public Livro toModel(EntityManager manager) {
        Autor autor = manager.find(Autor.class, autorId);
        Categoria categoria = manager.find(Categoria.class, categoriaId);

        Assert.state(Objects.nonNull(autor), "Autor não encontrado no banco de dados" + autorId);
        Assert.state(Objects.nonNull(categoria), "Categoria não encontrada no banco de dados " + categoriaId);

        return new Livro(
                titulo, sumario, isbn,
                resumo, preco, totalPaginas,
                dataLancamento, autor, categoria
        );
    }
}
