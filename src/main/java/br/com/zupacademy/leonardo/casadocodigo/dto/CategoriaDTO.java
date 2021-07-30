package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;
import br.com.zupacademy.leonardo.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public CategoriaDTO() {}

    public CategoriaDTO(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converte() {
        return new Categoria(this.nome);
    }
}
