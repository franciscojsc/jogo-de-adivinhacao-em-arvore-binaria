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
public class JogoComputador implements Serializable {

    public JogoComputador() {
        File file = arquivo;
        file.mkdir();
    }

    Scanner teclado = new Scanner(System.in);
    private Arvore jogo = new Arvore();

    private String diretorio = System.getProperty("user.home");
    // String userDir = System.getProperty("user.dir");// Uns dos caminhos padrÃ£o oferecidos pela JVM 
    private String separator = System.getProperty("file.separator"); //SEPARADOR DO SISTEMA OPERACIONAL ATUAL  
    // File arquivo = new File(userDir + separator + "guardarJogo");
    private File arquivo = new File(diretorio + separator + "guardarJogo");
    private String caminho = arquivo + separator + "computador.ser";

    private void inicializar() {
        String msg = "Insira a peça que pensou:";
        jogo.getRaiz().setEsq(addComputador(msg));
        msg = "Insira outra peÃ§a qualquer:";
        jogo.getRaiz().setDir(addComputador(msg));
    }

    private No addComputador(String msg) {
        No no = new No(verificarComputador(msg));
        return no;
    }

    private String verificarComputador(String msg) {
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
        boolean valida;
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
            System.out.println("Voçê venceu, ainda não sei nada, min ajude a aprender. ");
            String msg = "Adicione uma caracteristica da peÃ§a que pensou";

            jogo.add(verificarComputador(msg));
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
            System.out.println("A peça é:");
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
                System.out.println("VocÃª venceu, parabêns.");
                No novo = new No(arvore.getValor());
                arvore.setDir(novo);
                resp = "Adicione uma caracteristica da peça que pensou:";
                arvore.setValor(verificarComputador(resp));
                resp = "Adicione a peÃ§a que pensou.";
                arvore.setEsq(addComputador(resp));
                System.out.println("Obrigado por sua contribuição:");

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
