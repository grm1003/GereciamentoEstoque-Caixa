package com.estoque.gerenciamento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {
    static long cont = 0;
    private long id;
    private String nome;
    private String descricao;
    private float preco_unitario;
    private int quantStock;
    private int custoProd;

    public Produto(String nome, String descricao, float preco_unitario, int quantStock, int custoProd) {
        this.id = cont;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_unitario = preco_unitario;
        this.quantStock = quantStock;
        this.custoProd = custoProd;
        cont++;
    }

    @Override
    public String toString() {
        return "Produto:" +
                "Id:" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco_unitario=" + preco_unitario +
                ", quantStock=" + quantStock +
                ", custoProd=" + custoProd +
                '}';
    }
}
