/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.franciscochaves.jogo.adivinha;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        boolean valida = true;

        do {
            System.out.println("VAMOS BRINCAR, ESCOLHA UM TEMA");

            switch (tema()) {
                case 1:
                    JogoAnimal jogo = new JogoAnimal();
                    menuAnimal(jogo);
                    valida = verifica(teclado);

                    break;
                case 2:
                    JogoCasa jogoCasa = new JogoCasa();
                    menuCasa(jogoCasa);
                    valida = verifica(teclado);
                    break;
                case 3:
                    JogoComputador jogoComputador = new JogoComputador();
                    menuCasa(jogoComputador);
                    valida = verifica(teclado);
                    break;
                default:
                    break;
            }

            System.out.println("AT� LOGO");
        } while (valida);

    }

    private static boolean verifica(Scanner scanner) {
        String valor;
        boolean valida = false;
        boolean loop = false;

        do {
            System.out.println("DESEJA OUTRO TEMA S/N ?");
            valor = scanner.nextLine();
            if (valor.equalsIgnoreCase("s")) {
                valida = true;
                loop = true;
            } else if (valor.equalsIgnoreCase("n")) {
                valida = false;
                loop = true;
            } else {
                System.out.println("DIGITE S/N");
                loop = false;
            }
        } while (!loop);

        return valida;
    }

    @SuppressWarnings("resource")
	private static int tema() {
        Scanner teclado = new Scanner(System.in);
        boolean valida = false;
        String resp;
        int valor = 0;
        do {
            try {
                System.out.println("DIGITE 1 :TEMA ANIMAL");
                System.out.println("DIGITE 2: TEMA CASA");
                System.out.println("DIGITE 3: TEMA COMPUTADOR");
                resp = teclado.nextLine();
                valor = Integer.parseInt(resp);
                if (valor > 0 && valor <= 3) {
                    valida = true;
                } else {
                    System.out.println("DIGTE UM VALOR DE ACORDO COM O TEMA.");
                }
            } catch (Exception e) {
                System.out.println("DIGITE NÚMERO DE ACRODO COM O TEMA");
            }
        } while (!valida);

        return valor;

    }

    @SuppressWarnings({ "resource" })
    private static void menuAnimal(JogoAnimal jogo) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        boolean valida = true;
        String continuar;

        System.out.println("BEM VINDO \nVAMOS BRINCAR DE ADIVINHA \nTEMA ANIMAL\n");
        while (valida) {

            System.out.println("Pense em um animal...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("Pensou? \nResponda com S/N\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            jogo.joga();

            System.out.println("JOGO FINALIZADO");
            boolean aux = true;
            while (aux) {
                try {
                    System.out.println("DESEJA CONTINUAR S/N?");
                    continuar = teclado.nextLine();
                    if (continuar.equalsIgnoreCase("s") || continuar.equalsIgnoreCase("sim")) {
                        aux = false;
                        valida = true;
                    } else if (continuar.equalsIgnoreCase("n") || continuar.equalsIgnoreCase("não")) {
                        aux = false;
                        valida = false;
                    } else {
                        System.out.println("DIGITE S/N");
                        aux = true;
                    }
                } catch (Exception e) {
                    System.out.println("DIGITE S/N");
                }
            }

        }

        System.out.println("OBRIGADO, TE ESPERO DE NOVO.");
    }

    @SuppressWarnings({ "resource" })
    private static void menuCasa(JogoCasa jogo) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        boolean valida = true;
        String continuar;

        System.out.println("BEM VINDO \nVAMOS BRINCAR DE ADIVINHA \nTEMA CASA\n");
        while (valida) {

            System.out.println("Pense em um objeto que Tem em uma casa...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("Pensou? \nResponda com S/N\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            jogo.joga();

            System.out.println("JOGO FINALIZADO");
            boolean aux = true;
            while (aux) {
                try {
                    System.out.println("DESEJA CONTINUAR S/N?");
                    continuar = teclado.nextLine();
                    if (continuar.equalsIgnoreCase("s") || continuar.equalsIgnoreCase("sim")) {
                        aux = false;
                        valida = true;
                    } else if (continuar.equalsIgnoreCase("n") || continuar.equalsIgnoreCase("não")) {
                        aux = false;
                        valida = false;
                    } else {
                        System.out.println("DIGITE S/N");
                        aux = true;
                    }
                } catch (Exception e) {
                    System.out.println("DIGITE S/N");
                }
            }

        }

        System.out.println("OBRIGADO, TE ESPERO DE NOVO.");
    }

    @SuppressWarnings({ "resource" })
    private static void menuCasa(JogoComputador jogoComputador) throws IOException, ClassNotFoundException {
        Scanner teclado = new Scanner(System.in);
        boolean valida = true;
        String continuar;

        System.out.println("BEM VINDO \nVAMOS BRINCAR DE ADIVINHA \nTEMA COMPUTADOR\n");
        while (valida) {

            System.out.println("Pense em uma pe�a que Tem no computador...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("Pensou? \nResponda com S/N\n");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            jogoComputador.joga();

            System.out.println("JOGO FINALIZADO");
            boolean aux = true;
            while (aux) {
                try {
                    System.out.println("DESEJA CONTINUAR S/N?");
                    continuar = teclado.nextLine();
                    if (continuar.equalsIgnoreCase("s") || continuar.equalsIgnoreCase("sim")) {
                        aux = false;
                        valida = true;
                    } else if (continuar.equalsIgnoreCase("n") || continuar.equalsIgnoreCase("não")) {
                        aux = false;
                        valida = false;
                    } else {
                        System.out.println("DIGITE S/N");
                        aux = true;
                    }
                } catch (Exception e) {
                    System.out.println("DIGITE S/N");
                }
            }

        }

        System.out.println("OBRIGADO, TE ESPERO DE NOVO.");
    }

}
