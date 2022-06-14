package br.com.whiz.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private final List<FieldMessage> ERRORS = new ArrayList<>();

    public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors(){
        return ERRORS;
    }

    public void addError(String fieldName, String message){
        ERRORS.add(new FieldMessage(fieldName, message));
    }
}
