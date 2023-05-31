package com.estoque.gerenciamento.controller;

import com.estoque.gerenciamento.model.Pedido;
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
        ArrayList<Produto>myproducts = new ArrayList<>();
        ArrayList<Produto>estoque = new ArrayList<>();
        //adm padrão
        loja.auth.cadastraAdm("gui", "123");
        loja.auth.cadastraUsuario("gui1", "123");
        //cadastrandos os produtos
        loja.produtos.add(0, new Produto(0, "Bola", "Feito para jogar futebol", 47, 15, 30));
        loja.produtos.add(1, new Produto(1, "Relogio Curren", "Melhor Relogio Masculino", 104, 10, 55));
        loja.produtos.add(2, new Produto(2, "Soja", "Graos de Soja da Melhor Qualidade", 45, 80, 27));
        int choose = 0;
        

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
                    System.out.println("3 - Sair");

                    option = sc.nextInt();
                    switch (option){
                        case 1:
                            for (Produto prod: loja.produtos) {
                                System.out.println(prod);

                            }
                            break;

                        case 2 :
                            for (Produto prod: loja.produtos) {
                                System.out.println(prod);

                            }


                            while (choose!=2){

                                System.out.println("Digite o id do Produto");
                                int id = sc.nextInt();
                                System.out.println("Digite a Quantidade:");
                                int quant= scanner.nextInt();
                                loja.makeOrder(id,quant,myproducts);
                                System.out.println(myproducts);

                               
                                System.out.println("1 - Continuar Comprando");
                                System.out.println("2 - Finalizar Pedido");
                                 choose = scanner.nextInt();

                                 switch (choose){
                                     case 1:

                                     case 2:

                                         for (Produto prod: loja.produtos) {
                                             System.out.println(prod);

                                         }

                                         loja.pedidos.add(new Pedido(UserHashmap.get(email).getId(),myproducts,loja.calculaTotal(myproducts)));
                                         System.out.println(loja.pedidos.toString());
                                         loja.updateStock(myproducts);
                                         System.out.println(loja.retornaCaixa());
                                         myproducts.removeAll(myproducts);

                                         break;



                                 }
                                 if (choose == 3)break;
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

                        if(user.isAcesso_total()){
                            System.out.println("1 - Painel Adm");
                            System.out.println("2 - Realizar Pedido");
                            System.out.println("3 - Mostrar Produtos");
                            option = scanner.nextInt();
                            switch (option){
                                case 1:
                                    System.out.println("1 - Mostra Clientes");
                                    System.out.println("2 - Cadastrar Admin");
                                    System.out.println("3 - Cadastrar Usuario");
                                    System.out.println("4 - Relatorio de Vendas");
                                    System.out.println("5 - Cadastrar Produtos");
                                    System.out.println("6 - Adicionar Estoque");

                                    option =scanner.nextInt();
                                    switch (option){
                                        case 1:
                                            for(Usuario a : users){
                                                a.toString();
                                            }
                                           break;

                                        case 2:
                                            try {
                                                Scanner novo = new Scanner(System.in);
                                                System.out.println("Email:");
                                                email = novo.next();
                                                System.out.println("Senha:");
                                                senha = novo.next();
                                                loja.auth.cadastraAdm(email,senha);
                                            }catch (Exception e){
                                                System.out.println("Erro Ao Cadastrar");
                                            }
                                            break;


                                        case 3:
                                            Scanner sca = new Scanner(System.in);
                                            while (true){
                                                System.out.println("Email:");
                                                email = sca.next();
                                                System.out.println("Senha:");
                                                senha = sca.next();
                                                try {
                                                    loja.auth.cadastraUsuario(email, senha);
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Erro Cadastrar Usuario");
                                                }
                                            }
                                            break;

                                        case 4:
                                            System.out.println(loja.retornaCaixa());
                                            break;
                                        case 5:

                                            Scanner s = new Scanner(System.in);
                                            while (true){
                                                System.out.println("Nome:");
                                                String nome = s.next();
                                                System.out.println("Descricao:");
                                                String desc = s.next();
                                                System.out.println("Preco de Venda:");
                                                Double valor_un = s.nextDouble();
                                                System.out.println("Quantidade em Estoque:");
                                                int quant = s.nextInt();
                                                System.out.println("Preco de Custo Unitario:");
                                                Double custo = s.nextDouble();
                                                try {
                                                    Produto a = new Produto(nome,desc,valor_un,quant,custo);
                                                    loja.produtos.add(a);
                                                    break;
                                                } catch (Exception e) {
                                                    System.out.println("Erro em Adicionar produto");
                                                }
                                            }
                                            break;

                                        case 6:
                                            int escolha = 0;
                                            Scanner s1 = new Scanner(System.in);

                                            while (escolha!=2){

                                                System.out.println("1 - Adicionar");
                                                System.out.println("2 - Sair");
                                                escolha = s1.nextInt();
                                                switch (escolha){
                                                    case 1 :
                                                        for (Produto prod: loja.produtos) {
                                                            System.out.println(prod);

                                                        }

                                                        System.out.println("Digite o id do Produto");
                                                        int id = s1.nextInt();
                                                        System.out.println("Digite a Quantidade:");
                                                        int quant= scanner.nextInt();
                                                        loja.makeOrder(id,quant,estoque);
                                                        loja.attEstoque(estoque);
                                                        estoque.removeAll(estoque);
                                                        break;


                                                    case 2:
                                                        break;
                                                }


                                            }



                                            }
                            }



                        }else {
                            System.out.println("Digite uma opcao abaixo:");
                            System.out.println("1 - Mostrar Produtos");
                            System.out.println("2 - Realizar Pedido");
                            System.out.println("3 - Sair");
                            Scanner scan = new Scanner(System.in);
                            option = scan.nextInt();
                            switch (option){
                                case 1:
                                    for (Produto prod: loja.produtos) {
                                        System.out.println(prod);

                                    }
                                    break;

                                case 2 :
                                    for (Produto prod: loja.produtos) {
                                        System.out.println(prod);

                                    }

                                    while (choose!=2){

                                        System.out.println("Digite o id do Produto");
                                        int id = scan.nextInt();
                                        System.out.println("Digite a Quantidade:");
                                        int quant= scanner.nextInt();
                                        loja.makeOrder(id,quant,myproducts);
                                        System.out.println(myproducts);


                                        System.out.println("1 - Continuar Comprando");
                                        System.out.println("2 - Finalizar Pedido");
                                        choose = scanner.nextInt();

                                        switch (choose){
                                            case 1:

                                            case 2:

                                                for (Produto prod: loja.produtos) {
                                                    System.out.println(prod);

                                                }

                                                loja.pedidos.add(new Pedido(UserHashmap.get(user.getEmail()).getId(),myproducts,loja.calculaTotal(myproducts)));
                                                System.out.println(loja.pedidos.toString());
                                                loja.updateStock(myproducts);
                                                System.out.println(loja.retornaCaixa());
                                                myproducts.removeAll(myproducts);

                                                break;

                                        }
                                        if (choose == 3)break;
                                    }
                            }
                        }

                    }


            }


    }
}
