/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
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
    
    public Jogo(){
        
        random = new Random(System.currentTimeMillis());
        
        tamanho = 4;
        
        int x = random.nextInt(tamanho);
        int y = random.nextInt(tamanho);
        heroi = new Heroi(x, y);
        
        System.out.println(heroi);
        
        x = random.nextInt(tamanho);
        y = random.nextInt(tamanho);
        while(x== heroi.getPosX() && y==heroi.getPosY()){
            x = random.nextInt(tamanho);
            y = random.nextInt(tamanho);
        }
        
        vilao = new Vilao(x, y);
        
        System.out.println(vilao);
        
        this.posXDoubleAttack = random.nextInt(tamanho);
        this.posYDoubleAttack = random.nextInt(tamanho);
        
        System.out.println("");
        tabuleiro();
        
        
        
    }
    
    public void tabuleiro(){
        
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if(heroi.getPosX()==i && heroi.getPosY()==j){
                    System.out.print("H");
                    System.out.print(" ");
                }else if(vilao.getPosX()==i && vilao.getPosY()==j){
                    System.out.print("V");
                    System.out.print(" ");
                }else if(posXDoubleAttack == i && posYDoubleAttack==j){
                    System.out.print("B");
                    System.out.print(" ");
                }else{
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
    
    public boolean[] regras(){
        
        boolean regras[] = new boolean[9];
        
        // A maior prioriadade vai pro mais proximo de zero
        // Regra 01: SE a vida do vilão atual é menor que vida do vilão anterior
        // ENTÃO colocar o vilão em posição aleatória
        regras[0] = vidaVilaoAnterrior < vilao.getVida();
        // Regra 02: SE a posição atual for a mesma que a posição do vilão E a 
        // vida do vilão for menor que 1 ENTÃO vilão derrotado
        regras[1] = (vilao.check(heroi)) && vilao.getVida() < 1;
        // Regra 03: SE a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão
        regras[2] = vilao.check(heroi);
        // Regra 04: SE a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão E o bonus estar ativo dar o DOBRO do dano
        regras[3] = vilao.check(heroi);
        // Regra 05: SE a posição atual for a mesma que a posição do bonus
        // ENTÃO ativar o bonus
        regras[4] = (heroi.getPosX() == posXDoubleAttack) && (heroi.getPosY() == posYDoubleAttack);
        // Regra 06: SE o número da COLUNA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a ESQUERDA.
        regras[5] = (heroi.getPosY() > vilao.getPosY());
        // Regra 07: SE o número da COLUNA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a DIREIRA.
        regras[6] = heroi.getPosY() < vilao.getPosY();
        // Regra 08: SE o número da LINHA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a BAIXO.
        regras[7] = heroi.getPosX() < vilao.getPosX();
        // Regra 09: SE o número da LINHA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a CIMA.
        regras[8] = heroi.getPosX() > vilao.getPosX();
                
        return regras;
    }
    
    public void ciclo(){
        
        boolean regras[] = regras();
        
        if(regras[0] ){
            
        }
        
        if(regras[4]){
            heroi.setDoubleAttack(true);
        }
        
        if(regras[5]){
            heroi.move("esquerda");
        }
        
        if(regras[6]){
            heroi.move("direita");
        }
        
        if(regras[7]){
            heroi.move("baixo");
        }
        
        if(regras[8]){
            heroi.move("cima");
        }
        
    }
    
}
