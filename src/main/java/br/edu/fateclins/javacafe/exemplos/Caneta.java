/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fateclins.javacafe.exemplos;

/**
 *
 * @author apazi
 */
public class Caneta {
    private String cor;
    private String tamanho;
    private String marca;
    private boolean tampa;

    public Caneta(String cor, String tamanho, String marca, boolean tampa) {
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.tampa = tampa;
    }

    public Caneta() {
    }
    
    public void setCor(String cor){
        this.cor = cor;
    }
    
    public String getCor(){
        return this.cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isTampa() {
        return tampa;
    }

    public void setTampa(boolean tampa) {
        this.tampa = tampa;
    }
}
