package com.estoque.gerenciamento.service;

import com.estoque.gerenciamento.model.Pedido;
import com.estoque.gerenciamento.model.Produto;
import com.estoque.gerenciamento.service.Authorization;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@NoArgsConstructor
@Getter
public class Loja {

    public ArrayList<Produto> produtos;
    public ArrayList<Pedido>pedidos;

    public HashMap<Long,Produto> produtoHashMap;
    public HashMap<Long,Pedido> pedidoHashMap;
    public Authorization auth;
    static int cont = 0;


    public void makeOrder(int id, int quant, ArrayList<Produto> a){

       a.add(produtos.get(id));
       a.get(cont).setQuantStock(quant);
       cont++;


    }

    public Double calculaTotal(ArrayList<Produto> x){
        Iterator<Produto> it = x.iterator();
        Double total = 0.0;
        while (it.hasNext()){
            Produto one = it.next();
            total+= one.getPreco_unitario() * one.getQuantStock();

        }
        return total;
    }

}
