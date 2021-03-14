package com.acme.tarefasapispringboot.model;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@SequenceGenerator(name="autor_seq", initialValue = 1, allocationSize = 1)
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_seq")
    Long id;

    String nome;
}
