package br.com.whiz.resources.exception;

import br.com.whiz.service.exception.DataIntegrityException;
import br.com.whiz.service.exception.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrityException(DataIntegrityException die, HttpServletRequest request) {

        StandardError stde = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value()
                , "Data Integrity", die.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(stde);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException manve,
                                                                         HttpServletRequest request) {

        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error", manve.getMessage(), request.getRequestURI());
        for (FieldError fieldError : manve.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<StandardError> illegalStateException(IllegalStateException ilse,
                                                               HttpServletRequest request) {

        StandardError stde = new StandardError(System.currentTimeMillis(), HttpStatus.UNPROCESSABLE_ENTITY.value()
                , "Validation CPF", ilse.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(stde);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException onfe, HttpServletRequest request) {

        StandardError stde = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value()
                , "Object not found", onfe.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stde);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> DataIntegrityViolationException(DataIntegrityViolationException dive, HttpServletRequest request) {

        StandardError stde = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value()
                , "Data Integrity Violation", dive.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(stde);
    }
}
