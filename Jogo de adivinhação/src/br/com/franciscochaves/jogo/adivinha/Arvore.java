
package br.com.franciscochaves.jogo.adivinha;

import java.io.Serializable;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
public class Arvore implements Serializable{

    private No raiz;

    No getRaiz() {
        return raiz;
    }

    public boolean vazia() {
        return raiz == null;
    }
    
    public void add(String valor) {
        if (vazia()) {
            raiz = new No(valor);
        } else {
            No novo = new No(valor);
            add(raiz, novo);
        }
    }

    private void add(No arvore, No novo) {
        if (arvore.getValor().equals(novo.getValor())) {
            return;
        }
        if (novo.getValor().compareTo(arvore.getValor()) > 0) {
            if (arvore.getDir() == null) {
                arvore.setDir(novo);
            } else {
                add(arvore.getDir(), novo);
            }
        } else if (arvore.getEsq() == null) {
            arvore.setEsq(novo);
        } else {
            add(arvore.getEsq(), novo);
        }
    }
    
}
