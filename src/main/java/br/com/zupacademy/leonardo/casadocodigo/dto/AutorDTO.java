package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.*;

public class AutorDTO {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public AutorDTO(@NotBlank String nome, @NotBlank @Email String email,
                    @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converte() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
