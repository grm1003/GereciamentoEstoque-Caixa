package com.estoque.gerenciamento.controller;

import com.estoque.gerenciamento.model.Produto;
import com.estoque.gerenciamento.model.Token;
import com.estoque.gerenciamento.model.Usuario;
import com.estoque.gerenciamento.service.Authorization;
import com.estoque.gerenciamento.service.Loja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainStore {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();
        Scanner scanner = new Scanner(System.in);
        String email, senha;
        Boolean op;
        int option = 0;
        ArrayList<Usuario> users = new ArrayList<>();
        HashMap<String, Usuario> UserHashmap = new HashMap<>();
        loja.auth = new Authorization();
        loja.auth.setUsers(users);
        loja.auth.setUsuarioHashMap(UserHashmap);
        loja.produtos = new ArrayList<>();
        loja.pedidos = new ArrayList<>();
        //adm padrão
        loja.auth.cadastraAdm("gui", "123");
        //cadastrandos os produtos
        loja.produtos.add(0, new Produto(1, "Bola", "Feito para jogar futebol", 47, 15, 30));
        loja.produtos.add(1, new Produto(2, "Relogio Curren", "Melhor Relogio Masculino", 104, 10, 55));
        loja.produtos.add(2, new Produto(3, "Soja", "Graos de Soja da Melhor Qualidade", 45, 80, 27));

        while (option != 3) {
            System.out.println("Digite Uma das Opcoes Abaixo: ");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Login");
            System.out.println("3 - Sair");


            option = scanner.nextInt();

            switch (option) {
                case 1:
                        Scanner sc = new Scanner(System.in);
                        while (true){
                            System.out.println("Email:");
                        email = sc.next();
                        System.out.println("Senha:");
                        senha = sc.next();
                        try {
                            loja.auth.cadastraUsuario(email, senha);
                            break;
                        } catch (Exception e) {
                            System.out.println("Erro Cadastrar Usuario");
                        }
                    }
                    System.out.println("Digite uma opcao abaixo:");
                    System.out.println("1 - Mostrar Produtos");
                    System.out.println("2 - Realizar Pedido");

                    option = sc.nextInt();
                    switch (option){
                        case 1:
                            for (Produto prod: loja.produtos) {
                                System.out.println(prod);

                            }
                    }

                    break;

                case 2:
                    Token user = null;
                    while (user == null) {
                        Scanner s = new Scanner(System.in);
                        System.out.println("-------Login-------\n");
                        System.out.println("Email:");
                        email = s.next();
                        System.out.println("Senha:");
                        senha = s.next();
                        Usuario a = new Usuario(email, senha);
                        try {
                            Token b = loja.auth.geraToken(a);
                            user = b;
                        } catch (Exception e) {
                            System.out.println("Erro login");
                        }
                    }


            }


        }
    }
}
