package br.com.zupacademy.leonardo.casadocodigo.validator;

import br.com.zupacademy.leonardo.casadocodigo.dto.EstadoForm;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueEstadoValidator implements ConstraintValidator<UniqueEstado, EstadoForm> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(UniqueEstado constraintAnnotation) {
    }

    @Override
    public boolean isValid(EstadoForm value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select i from Estado i where nome =:nome " +
                " and pais_id =:paisId");
        query.setParameter("nome", value.getNome());
        query.setParameter("paisId", value.getPaisId());

        List<?> list = query.getResultList();

        Assert.state(list.size() <= 1, "Há mais de um estado com esse nome neste país");

        return list.isEmpty();
    }
}
