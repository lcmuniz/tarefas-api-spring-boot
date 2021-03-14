package com.acme.tarefasapispringboot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity @Data
@SequenceGenerator(name="tarefa_seq", initialValue = 1, allocationSize = 1)
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarefa_seq")
    Long id;

    String titulo;
    String texto;

    @ManyToOne
    Autor autor;

    Date dataInicio;
    Date dataFim;
}
