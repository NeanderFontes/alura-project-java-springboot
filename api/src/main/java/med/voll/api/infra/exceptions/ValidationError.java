package med.voll.api.infra.exceptions;


import org.springframework.validation.FieldError;

public record ValidationError(
        String field,
        String message) {

    public ValidationError(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}