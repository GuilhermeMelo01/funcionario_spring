package br.com.whiz.service.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class IllegalStateException extends RuntimeException{

    public IllegalStateException(String message){
        super(message);
    }

    public IllegalStateException(String message, Throwable cause){
        super(message, cause);
    }
}
