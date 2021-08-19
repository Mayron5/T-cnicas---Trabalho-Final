/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mayron
 */
public class Jogos {
 
    private String nome;
    private float valor;
    private float tamanho_jogo;
    private int classificacao_etaria;
    private String pre_requisitos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTamanho_jogo() {
        return tamanho_jogo;
    }

    public void setTamanho_jogo(float tamanho_jogo) {
        this.tamanho_jogo = tamanho_jogo;
    }

    public int getClassificacao_etaria() {
        return classificacao_etaria;
    }

    public void setClassificacao_etaria(int classificacao_etaria) {
        this.classificacao_etaria = classificacao_etaria;
    }

    public String getPre_requisitos() {
        return pre_requisitos;
    }

    public void setPre_requisitos(String pre_requisitos) {
        this.pre_requisitos = pre_requisitos;
    }
    
    
    
}
