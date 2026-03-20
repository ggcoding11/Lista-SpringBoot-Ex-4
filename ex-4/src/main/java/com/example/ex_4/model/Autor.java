package com.example.ex_4.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coluna_nome")
    private String nome;

    @Column(name = "coluna_nacionalidade")
    private String nacionalidade;

    @Column(name = "coluna_data_nascimento")
    private LocalDate dataNascimento;
}