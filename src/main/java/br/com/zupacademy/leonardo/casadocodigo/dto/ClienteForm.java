package br.com.zupacademy.leonardo.casadocodigo.dto;

import br.com.zupacademy.leonardo.casadocodigo.model.Cliente;
import br.com.zupacademy.leonardo.casadocodigo.model.Estado;
import br.com.zupacademy.leonardo.casadocodigo.model.Pais;
import br.com.zupacademy.leonardo.casadocodigo.validator.ExistId;
import com.sun.istack.NotNull;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class ClienteForm {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    @ExistId(domainClass = Estado.class, fieldName = "id")
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    @Deprecated
    public ClienteForm() {}

    public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobreNome,
                       @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                       @NotBlank String cidade, @NotNull Long paisId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getDocumento() {
        return documento;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    @Override
    public String toString() {
        return "ClienteForm{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", documento='" + documento + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", paisId=" + paisId +
                ", estadoId=" + estadoId +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public boolean validaDocumento() {
        Assert.hasLength(documento, "Campo documento precisa estar preenchido!");

        CPFValidator cpf = new CPFValidator();
        cpf.initialize(null);

        CNPJValidator cnpj = new CNPJValidator();
        cnpj.initialize(null);

        return cpf.isValid(documento, null) || cnpj.isValid(documento, null);
    }

    public Cliente toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, paisId);
        Cliente cliente = new Cliente(email, nome, sobreNome, documento, endereco, complemento, cidade,
                pais, telefone, cep);

        if(estadoId != null) {
            cliente.setEstado(manager.find(Estado.class, estadoId));
        }

        return cliente;
    }

    public boolean temEstado() {
        return Optional.ofNullable(estadoId).isPresent();
    }
}
