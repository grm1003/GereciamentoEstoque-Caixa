package com.estoque.gerenciamento.service;

import com.estoque.gerenciamento.model.Pedido;
import com.estoque.gerenciamento.model.Produto;
import com.estoque.gerenciamento.service.Authorization;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.HashMap;

@NoArgsConstructor
@Getter
public class Loja {

    public ArrayList<Produto> produtos;
    public ArrayList<Pedido>pedidos;

    public HashMap<Long,Produto> produtoHashMap;
    public HashMap<Long,Pedido> pedidoHashMap;
    public Authorization auth;


}
