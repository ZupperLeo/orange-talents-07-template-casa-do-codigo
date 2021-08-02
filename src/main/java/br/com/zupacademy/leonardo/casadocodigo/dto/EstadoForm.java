package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Estado;
import br.com.zupacademy.leonardo.casadocodigo.model.Pais;
import br.com.zupacademy.leonardo.casadocodigo.validator.ExistId;
import br.com.zupacademy.leonardo.casadocodigo.validator.UniqueEstado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueEstado()
public class EstadoForm {

    @NotBlank
    private String nome;
    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;

    public EstadoForm(@NotBlank String nome, @NotNull Long paisId) {
        super();
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    @Override
    public String toString() {
        return "EstadoDTO{" +
                "nome='" + nome + '\'' +
                ", paisId=" + paisId +
                '}';
    }

    public Estado toModel(EntityManager manager) {
        return new Estado(nome, manager.find(Pais.class, paisId));
    }
}
