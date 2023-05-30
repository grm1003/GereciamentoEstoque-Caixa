package com.estoque.gerenciamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Token {
    long id;
    String email;
    boolean acesso_total;
}
