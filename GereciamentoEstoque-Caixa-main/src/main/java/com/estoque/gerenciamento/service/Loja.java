package com.estoque.gerenciamento.service;

import com.estoque.gerenciamento.model.Pedido;
import com.estoque.gerenciamento.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Double calculaCusto(ArrayList<Produto> x){
        Iterator<Produto> it = x.iterator();
        Double total = 0.0;
        while (it.hasNext()){
            Produto one = it.next();
            total = total + one.getCustoProd() * one.getQuantStock();

        }
        return total;
    }
    public String mostraProdutos(ArrayList<Produto> produtos){
        String word ="";
        for(Produto a:produtos){
            word += a.MostraCliente();
        }
        return word;
    }

    public String retornaCaixa(){
       double Faturamento,Custo_Vendidos,Lucro, Faturamento_Potencial, Lucro_Potencial,Custo_Total;
       ArrayList<Produto> comprados = new ArrayList<Produto>();
       pedidos.forEach(element-> element.getProdutos().forEach(produto -> comprados.add(produto)));
       Faturamento = calculaTotal(comprados);
       Custo_Vendidos = calculaCusto(comprados);
       Lucro = Faturamento - Custo_Vendidos;
       //potencial de faturamento dos produtos os quais ainda não foram vendidos
        Faturamento_Potencial = calculaTotal(this.produtos);
        Custo_Total = calculaCusto(this.produtos);
        Lucro_Potencial = Faturamento_Potencial - Custo_Total;
        return "---------------------------CAIXA------------------------------------"+ "\n" +
                "Atual: " + "\n" +
                "Faturamento: " + Faturamento + "\n" +
                "Custo: " + Custo_Vendidos  + "\n" +
                "Lucro:" + Lucro + "\n" +
                "-----------------------FUTURO------------------------" +
                "Potencial de Vendas Futuras: " + "\n" +
                "Faturamento: " + Faturamento_Potencial + "\n" +
                "Custo: " + Custo_Total  + "\n" +
                "Lucro:" + Lucro_Potencial + "\n" +
                "-----------------------FIM DE FLUXO---------------------------------";
    }



}
