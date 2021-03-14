package com.acme.tarefasapispringboot.repository;

import com.acme.tarefasapispringboot.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
