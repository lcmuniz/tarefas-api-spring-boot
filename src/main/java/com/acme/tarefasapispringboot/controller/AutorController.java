package com.acme.tarefasapispringboot.controller;

import com.acme.tarefasapispringboot.exception.AutorNaoEncontradoException;
import com.acme.tarefasapispringboot.model.Autor;
import com.acme.tarefasapispringboot.model.Tarefa;
import com.acme.tarefasapispringboot.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository repo;

    @GetMapping
    List<Autor> findAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    Autor findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new AutorNaoEncontradoException(id));
    }

    @PostMapping
    Autor insert(@RequestBody Autor autor) {
        return repo.save(autor);
    }

    @PutMapping("/{id}")
    Autor update(@PathVariable Long id, @RequestBody Autor autor) {
        return repo.findById(id).map(a -> {
            if (autor.getNome() != null) a.setNome(autor.getNome());
            return a;
        }).orElseThrow(() -> new AutorNaoEncontradoException(id));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        Autor autor = repo.findById(id).orElseThrow(() -> new AutorNaoEncontradoException(id));
        repo.delete(autor);
    }

}
