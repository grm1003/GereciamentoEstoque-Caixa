package com.estoque.gerenciamento.service;

import com.estoque.gerenciamento.model.Token;
import com.estoque.gerenciamento.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
@NoArgsConstructor
@Getter
@Setter
public class Authorization {

    final String secret = "20042003authGabrielGuilhermeOk";
    private ArrayList<Usuario> users;
    private HashMap<String,Usuario>usuarioHashMap;

    public boolean autenticaUser(Usuario a){
        boolean retorno = false;
       if(usuarioHashMap.containsKey(a.getEmail())){
         if ((a.getSenha()+secret).equals(usuarioHashMap.get(a.getEmail()).getSenha()))
             retorno = true;
        }
        return retorno;
    }

    public boolean verificarAdm(Usuario a){
        boolean retorno = false;
        if(autenticaUser(a))
            if (usuarioHashMap.get(a.getEmail()).isAdm()) retorno = true;
        return  retorno;
    }

    public Token geraToken(Usuario a) throws Exception {
        if(autenticaUser(a)){
            Token b = new Token(a.getId(), a.getEmail(), verificarAdm(a));
            return b;
        }else throw new Exception("Acesso negado");
    }

    public void cadastraUsuario(String email, String senha) throws Exception {
        if(usuarioHashMap.containsKey(email))throw new Exception("Email invalido");
        Usuario a = new Usuario(email,senha+secret,false);
        users.add(a);
        usuarioHashMap.put(a.getEmail(),a);
    }

    public void cadastraAdm(String email, String senha) throws Exception {
        if(usuarioHashMap.containsKey(email))throw new Exception("Email invalido");
        Usuario a = new Usuario(email,senha+secret,true);
        users.add(a);
        usuarioHashMap.put(a.getEmail(),a);
    }

    public String imprimeUsers(Token admin){
        if (admin.isAcesso_total()){
            for (Usuario b : this.users) {
                return b.toString();
            }
        }
        return "Acesso Negado";
    }


}
