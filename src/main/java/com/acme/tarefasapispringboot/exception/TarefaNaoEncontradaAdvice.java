package com.acme.tarefasapispringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TarefaNaoEncontradaAdvice {

    @ResponseBody
    @ExceptionHandler(TarefaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String tarefaNaoEncontrada(TarefaNaoEncontradaException ex) {
        return ex.getMessage();
    }

}
