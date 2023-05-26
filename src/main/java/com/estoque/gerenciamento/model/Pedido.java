package com.estoque.gerenciamento.model;

import com.estoque.gerenciamento.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class Pedido {
    private int id;
    private long idUsuario;
    private ArrayList<Produto> produtos;
    private double total;

    private String printaProdutos(){
        String listString = getProdutos().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        return listString;
    }

    @Override
    public String toString() {
        return "----------------------------------" + "\n" +"Pedido:" + "\n" +
                "Id:" + id + "\n" +
                "IdUsuario" + idUsuario + "\n" +
                "Produtos:" + printaProdutos() + "\n" +
                "Total=" + total + "\n" +
                "----------------------------------";
    }
}