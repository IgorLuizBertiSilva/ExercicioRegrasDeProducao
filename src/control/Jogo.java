/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import java.util.Scanner;
import model.Heroi;
import model.Vilao;

/**
 *
 * @author Aluno
 */
public class Jogo {

    private int posXDoubleAttack;
    private int posYDoubleAttack;

    private Heroi heroi;
    private Vilao vilao;

    private int tamanho;

    private int vidaVilaoAnterrior;

    private Random random;

    private Scanner scanner;

    public Jogo() {

        scanner = new Scanner(System.in);

        random = new Random(System.currentTimeMillis());

        tamanho = 10;

        int x = random.nextInt(tamanho);
        int y = random.nextInt(tamanho);
        heroi = new Heroi(x, y);

        System.out.println(heroi);

        
        
        this.posXDoubleAttack = random.nextInt(tamanho);
        this.posYDoubleAttack = random.nextInt(tamanho);
        while(bonusMesmoLugar()){
            this.posXDoubleAttack = random.nextInt(tamanho);
            this.posYDoubleAttack = random.nextInt(tamanho);
        }
        
        x = random.nextInt(tamanho);
        y = random.nextInt(tamanho);
        
        vilao = new Vilao(x, y);
        
        while (vilaoMesmoLugar()) {
            vilao.setPosX(random.nextInt(tamanho));
            vilao.setPosY(random.nextInt(tamanho));
            
            
        }

        

        System.out.println(vilao);
        
        
        

        
        vidaVilaoAnterrior = vilao.getVida();
        
        System.out.println("");
        
        tabuleiro();
        
        boolean sair = true;

        while (sair) {

            String pass = scanner.nextLine();

            tabuleiro();
            
            sair = ciclo();

        }

    }

    public void tabuleiro() {

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (heroi.getPosX() == j && heroi.getPosY() == i) {
                    System.out.print("H");
                    System.out.print(" ");
                } else if (vilao.getPosX() == j && vilao.getPosY() == i) {
                    System.out.print("V");
                    System.out.print(" ");
                } else if (posXDoubleAttack == j && posYDoubleAttack == i) {
                    System.out.print("B");
                    System.out.print(" ");
                } else {
                    System.out.print("_");
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Vida do Vilão: " + vilao.getVida());
        System.out.println("Tem bonus ? " + heroi.isDoubleAttack());
    }

//    public void movimento(){
//        
//        if(vilao.getVida() < vidaVilaoAnterrior){
//            int x = random.nextInt(10);
//            int y = random.nextInt(10);
//            while(x== heroi.getPosX() && y==heroi.getPosY()){
//                x = random.nextInt(10);
//                y = random.nextInt(10);
//            }
//            vidaVilaoAnterrior = vilao.getVida();
//        }else {
//            if(vilao.check(heroi)){
//            
//                if(heroi.isDoubleAttack()){
//                    this.vidaVilaoAnterrior = vilao.getVida();
//                    vilao.dano(2);
//                    if(vilao.getVida() < 1){
//                        System.out.println("");
//                    }
//                }else{
//                    this.vidaVilaoAnterrior = vilao.getVida();
//                    vilao.dano(1);
//                }
//            }
//        }
//        
//    }
    public boolean[] regras() {

        boolean regras[] = new boolean[9];

        // A maior prioriadade vai pro mais proximo de zero
        // Regra 01: SE a vida do vilão atual é menor que vida do vilão anterior
        // ENTÃO colocar o vilão em posição aleatória
        regras[0] = (vilao.check(heroi)) && vilao.getVida() < 1;
        // Regra 02: SE a posição atual for a mesma que a posição do vilão E a 
        // vida do vilão for menor que 1 ENTÃO vilão derrotado
        regras[1] = vidaVilaoAnterrior != vilao.getVida();
        // Regra 03: E a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão E o bonus estar ativo dar o DOBRO do dano
        regras[2] = vilao.check(heroi) && heroi.isDoubleAttack();
        // Regra 04: SE a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão
        regras[3] = vilao.check(heroi);
        // Regra 05: SE a posição atual for a mesma que a posição do bonus
        // ENTÃO ativar o bonus
        regras[4] = (heroi.getPosX() == posXDoubleAttack) && (heroi.getPosY() == posYDoubleAttack);
        // Regra 06: SE o número da COLUNA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a ESQUERDA.
        regras[5] = (heroi.getPosX() > vilao.getPosX());
        // Regra 07: SE o número da COLUNA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a DIREIRA.
        regras[6] = heroi.getPosX() < vilao.getPosX();
        // Regra 08: SE o número da LINHA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a BAIXO.
        regras[7] = heroi.getPosY() < vilao.getPosY();
        // Regra 09: SE o número da LINHA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a CIMA.
        regras[8] = heroi.getPosY() > vilao.getPosY();

        return regras;
    }

    public boolean ciclo() {

        boolean regras[] = regras();
        
        int i = 0;
        
        for (boolean regra : regras) {
            
            System.out.println("Regra " + i + ": " + regra);
            i++;
        }

        if (regras[0]) {
            
            System.out.println("!!Fim do Jogo!!");
            return false;
            
        } else if (regras[1]) {
            
           
            
            int x = random.nextInt(tamanho);
            int y = random.nextInt(tamanho);
            while(vilaoMesmoLugar()){
                x = random.nextInt(tamanho);
                y = random.nextInt(tamanho);
            }
            
            vilao.teleporte(x, y);
            
            vidaVilaoAnterrior = vilao.getVida();
            
            System.out.println("Vilao se Teleportou");
            

        } else if (regras[2]) {
            
            System.out.println("Dano Dobrado");
            vidaVilaoAnterrior = vilao.getVida();
            vilao.dano(2);
            heroi.setDoubleAttack(false);
            
            
            

        } else if (regras[3]) {

            System.out.println("Dano");
            vidaVilaoAnterrior = vilao.getVida();
            vilao.dano(1);

        } else if (regras[4]) {
            heroi.setDoubleAttack(true);
            posXDoubleAttack = -1;
            posYDoubleAttack = -1;

        } else if (regras[5]) {
            System.out.println("Esquerda");
            System.out.println(heroi);
            System.out.println(vilao);
            heroi.move("esquerda");

        } else if (regras[6]) {
            System.out.println("Direita");
            System.out.println(heroi);
            System.out.println(vilao);
            heroi.move("direita");

        } else if (regras[7]) {
            System.out.println("Baixo");
            System.out.println(heroi);
            System.out.println(vilao);
            heroi.move("baixo");

        } else if (regras[8]) {
            System.out.println("Cima");
            System.out.println(heroi);
            System.out.println(vilao);
            heroi.move("cima");
        }
        
        return true;

    }
    
    public boolean vilaoMesmoLugar(){
        
        return ((vilao.getPosX() == heroi.getPosX() && vilao.getPosY() == heroi.getPosY()) 
                && (vilao.getPosX() == posXDoubleAttack && vilao.getPosY() == posYDoubleAttack));
        
    }
    
    public boolean bonusMesmoLugar(){
        
        
        return (((posXDoubleAttack == heroi.getPosX()) && (posYDoubleAttack == heroi.getPosY())));
        
        
    }

}
