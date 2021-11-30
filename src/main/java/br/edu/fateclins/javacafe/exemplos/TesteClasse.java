/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.exemplos;

import br.edu.fateclins.javacafe.modelo.Usuario;

/**
 *
 * @author apazi
 */
public class TesteClasse {
    public static void main(String[] args) {
//        Caneta bic = new Caneta();
//        bic.setCor("azul");
//        System.out.println("Cor da caneta é: "+bic.getCor());
//        Caneta bic2 = new Caneta("verde","14cm","bic",true);
//        //bic.setCor("vermelha");
//        System.out.println("Cor da caneta é: "+bic2.getCor());

        Usuario user = new Usuario();
        String senha = "a123A1+3";
        if(user.validarFormatoSenha(senha)){
            user.setSenha(senha);
            System.out.println(user.getSenha());
        } else {
            System.out.println("Formato de senha inválido!");
        }
    }
}
