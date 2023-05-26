package com.estoque.gerenciamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class Usuario {
    static long ct = 0;
    private long id;
    private String email;
    private String senha;
    private boolean isAdm;

    public Usuario(String email, String senha, boolean isAdm) {
        this.id = ct;
        this.email = email;
        this.senha = senha;
        this.isAdm = isAdm;
        ct++;
    }

    //somente utilizado
    public Usuario(String email, String senha) {
        this.id = 0;
        this.email = email;
        this.senha = senha;
        this.isAdm = false;
    }

    @Override
    public String toString() {
        return "----------------------------------" + "\n" +"Usuario:" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", isAdm=" + isAdm +
                '}';
    }


}
