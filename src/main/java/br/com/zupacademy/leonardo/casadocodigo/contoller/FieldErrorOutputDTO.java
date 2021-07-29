package br.com.zupacademy.leonardo.casadocodigo.contoller;

import java.util.ArrayList;
import java.util.List;

public class FieldErrorOutputDTO {

    private String field;
    private String message;

    FieldErrorOutputDTO() {
    }

    public FieldErrorOutputDTO(String field, String message) {
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }

}
