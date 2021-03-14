package com.acme.tarefasapispringboot.repository;

import com.acme.tarefasapispringboot.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findAllByAutorId(Long id);
}
