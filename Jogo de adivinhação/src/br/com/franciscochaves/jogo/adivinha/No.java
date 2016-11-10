/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.franciscochaves.jogo.adivinha;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
public class No implements Serializable{

    private String valor;
    private No esq;
    private No dir;

    public No() {
    }

    public No(String valor) {
        this.valor = valor;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the esq
     */
    public No getEsq() {
        return esq;
    }

    /**
     * @param esq the esq to set
     */
    public void setEsq(No esq) {
        this.esq = esq;
    }

    /**
     * @return the dir
     */
    public No getDir() {
        return dir;
    }

    /**
     * @param dir the dir to set
     */
    public void setDir(No dir) {
        this.dir = dir;
    }

}
