package com.acme.tarefasapispringboot.controller;

import com.acme.tarefasapispringboot.exception.TarefaNaoEncontradaException;
import com.acme.tarefasapispringboot.model.Tarefa;
import com.acme.tarefasapispringboot.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    TarefaRepository repo;

    @GetMapping
    List<Tarefa> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    Tarefa findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    @PostMapping
    Tarefa insert(@RequestBody Tarefa tarefa) {
        return repo.save(tarefa);
    }

    @PutMapping("/{id}")
    Tarefa update(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return repo.findById(id).map(t -> {
            if (tarefa.getTitulo() != null) t.setTitulo(tarefa.getTitulo());
            if (tarefa.getTexto() != null) t.setTexto(tarefa.getTexto());
            if (tarefa.getAutor() != null) t.setAutor(tarefa.getAutor());
            if (tarefa.getDataInicio() != null) t.setDataInicio(tarefa.getDataInicio());
            if (tarefa.getDataFim() != null) t.setDataFim(tarefa.getDataFim());
            return t;
        }).orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        Tarefa tarefa = repo.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException(id));
        repo.delete(tarefa);
    }

    @GetMapping("/autor/{id}")
    List<Tarefa> findAllByAutorId(@PathVariable Long id) {
        return repo.findAllByAutorId(id);
    }
}
