package br.com.zupacademy.leonardo.casadocodigo.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String titulo;
    private @NotBlank @Lob String sumario;
    private @NotBlank String isbn;
    private @NotBlank @Size(max = 500) String resumo;
    private @NotNull @Min(20) BigDecimal preco;
    private @NotNull @Min(100) Integer totalPaginas;
    private @NotNull @Future LocalDate dataLancamento;
    private @ManyToOne @Valid @NotNull Autor autor;
    private @ManyToOne @Valid @NotNull Categoria categoria;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank String sumario, @NotBlank String isbn,
                 @NotBlank @Size(max = 500) String resumo, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) Integer totalPaginas, @NotNull @Future LocalDate dataLancamento,
                 @Valid @NotNull Autor autor, @Valid @NotNull Categoria categoria) {
        this.titulo = titulo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.resumo = resumo;
        this.preco = preco;
        this.totalPaginas = totalPaginas;
        this.dataLancamento = dataLancamento;
        this.autor = autor;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResumo() {
        return resumo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getTotalPaginas() {
        return totalPaginas;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", isbn='" + isbn + '\'' +
                ", resumo='" + resumo + '\'' +
                ", preco=" + preco +
                ", totalPaginas=" + totalPaginas +
                ", dataLancamento=" + dataLancamento +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

}
