package com.acme.tarefasapispringboot.exception;

public class AutorNaoEncontradoException extends RuntimeException {
    public AutorNaoEncontradoException(Long id) {
        super("Autor " + id + " não encontrado");
    }
}
