package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Autor;
import br.com.zupacademy.leonardo.casadocodigo.repository.AutorRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class AutorDTO {

    private @NotBlank String nome;
    private @NotBlank @Email String email;
    private @NotBlank @Size(max = 400) String descricao;

    public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
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
