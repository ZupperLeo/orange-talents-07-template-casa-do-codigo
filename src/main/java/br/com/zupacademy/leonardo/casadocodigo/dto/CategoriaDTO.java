package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    private @NotBlank String nome;

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
