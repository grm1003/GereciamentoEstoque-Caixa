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
    private static int cont = 0;
    private int id;
    private long idUsuario;
    private ArrayList<Produto> produtos;
    private double total;

    public Pedido(long idUsuario, ArrayList<Produto> produtos,double total) {
        this.idUsuario = idUsuario;
        this.produtos = produtos;
        this.cont = 0;
        this.total = total;
        cont++;

    }

    private String printaProdutos(){
        String listString = getProdutos().stream().map(Object::toString)
                .collect(Collectors.joining(", "));
        return listString;
    }



    @Override
    public String toString() {
        return "----------------------------------" + "\n" +"Pedido:" + "\n" +
                "Id: " + id + "\n" +
                "IdUsuario: " + idUsuario + "\n" +
                "Produtos :" + printaProdutos() + "\n" +
                "Total= " + total + "\n" +
                "----------------------------------";
    }
}