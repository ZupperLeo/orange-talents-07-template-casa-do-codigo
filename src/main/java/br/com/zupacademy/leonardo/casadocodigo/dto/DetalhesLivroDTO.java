package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;
import br.com.zupacademy.leonardo.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalhesLivroDTO {

    private String titulo;
    private String sumario;
    private String isbn;
    private String resumo;
    private BigDecimal preco;
    private Integer totalPaginas;
    private LocalDate dataLancamento;
    private Autor autor;

    public DetalhesLivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsbn();
        this.resumo = livro.getResumo();
        this.preco = livro.getPreco();
        this.totalPaginas = livro.getTotalPaginas();
        this.dataLancamento = livro.getDataLancamento();
        this.autor = livro.getAutor();
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
}
