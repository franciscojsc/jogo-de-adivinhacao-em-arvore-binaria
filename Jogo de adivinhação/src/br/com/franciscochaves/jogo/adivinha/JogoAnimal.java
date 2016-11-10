/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.franciscochaves.jogo.adivinha;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
@SuppressWarnings("serial")
public class JogoAnimal implements Serializable {

    Scanner Teclado = new Scanner(System.in);

    public JogoAnimal() {
        File file = arquivo;
        file.mkdir();
    }

    Scanner teclado = new Scanner(System.in);
    private Arvore jogo = new Arvore();

    private String diretorio = System.getProperty("user.home");
    // String userDir = System.getProperty("user.dir");// Uns dos caminhos padrão oferecidos pela JVM 
    private String separator = System.getProperty("file.separator"); //SEPARADOR DO SISTEMA OPERACIONAL ATUAL  
    // File arquivo = new File(userDir + separator + "guardarJogo");
    private File arquivo = new File(diretorio + separator + "guardarJogo");
    private String caminho = arquivo + separator + "objeto.ser";

    private void inicializar() {

        String msg = "Insira um animal que pensou:";
        jogo.getRaiz().setEsq(addAnimal(msg));
        msg = "Insira outro animal qualquer:";
        jogo.getRaiz().setDir(addAnimal(msg));

    }

    private No addAnimal(String msg) {
        No no = new No(verificarAnimal(msg));
        return no;
    }

    private String verificarAnimal(String msg) {
        boolean valida = false;
        String resposta = null;

        while (!valida) {
            System.out.println(msg);
            resposta = teclado.nextLine();
            if (resposta.matches(".+")) {
                valida = true;
            } else {
                System.out.println("Insira de acordo com o solicitado.");
            }
        }
        return resposta;
    }

    private String TestResposta() {
        String resposta;
        boolean valida = true;
        do {
            System.out.println("Digite S/N");
            resposta = teclado.nextLine();
            if (resposta.equalsIgnoreCase("s")) {
                valida = false;
            } else if (resposta.equalsIgnoreCase("n")) {
                valida = false;
            } else {
                System.out.println("Insira de acordo com o solicitado.");
                valida = true;
            }

        } while (valida);
        return resposta;
    }

    public void joga() throws IOException, ClassNotFoundException {

        jogo = recuperarJogo();

        if (jogo.vazia()) {
            System.out.println("Vo�� venceu, ainda n�o sei nada, min ajude a aprender. ");
            String msg = "Adicione uma caracteristica do animal que pensou:";

            jogo.add(verificarAnimal(msg));
            inicializar();
            armazenarJogo();
            return;
        }

        joga(jogo.getRaiz());
        armazenarJogo();
    }

    private void joga(No arvore) {
        if (arvore == null) {
            return;
        }
        if (isfolha(arvore)) {// se folha
            System.out.println("O animal �:");
        }
        System.out.println(arvore.getValor());

        String resp = TestResposta();
        if (resp.equalsIgnoreCase("s") && isfolha(arvore)) {
            System.out.println("Boa sorte na proxima,kkkkkkk");
        }

        if (resp.equalsIgnoreCase("S")) {
            if (arvore.getEsq() != null) {
                joga(arvore.getEsq());
            }
        } else if (resp.equalsIgnoreCase("N")) {
            if (arvore.getDir() == null) {
                System.out.println("Voc� venceu, parab�ns.");
                No novo = new No(arvore.getValor());
                arvore.setDir(novo);
                resp = "Adicione uma caracteristica do animal que pensou:";
                arvore.setValor(verificarAnimal(resp));
                resp = "Adicione o animal que pensou:";
                arvore.setEsq(addAnimal(resp));
                System.out.println("Obrigado por sua contribui��o.");

            } else {
                joga(arvore.getDir());
            }
        }
    }

    public boolean isfolha(No arvore) {
        return arvore.getDir() == null && arvore.getEsq() == null;
    }

    private void armazenarJogo() throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(
                caminho)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(this.jogo);
            }
        }
    }

    private Arvore recuperarJogo() throws IOException, ClassNotFoundException {
        Arvore leitura = new Arvore();
        try (FileInputStream j = new FileInputStream(caminho);
                ObjectInputStream reader = new ObjectInputStream(j)) {
            leitura = (Arvore) reader.readObject();
        } catch (Exception e) {
        }
        return leitura;
    }
}
