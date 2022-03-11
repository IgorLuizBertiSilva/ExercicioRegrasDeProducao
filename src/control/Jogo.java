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
    
    private int vidaVilaoAnterrior;
    
    private Random random;
    
    public Jogo(){
        
        random = new Random(System.currentTimeMillis());
        
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        heroi = new Heroi(x, y);
        
        System.out.println(heroi);
        
        x = random.nextInt(10);
        y = random.nextInt(10);
        while(x== heroi.getPosX() && y==heroi.getPosY()){
            x = random.nextInt(10);
            y = random.nextInt(10);
        }
        
        vilao = new Vilao(x, y);
        
        System.out.println(vilao);
        
        this.posXDoubleAttack = random.nextInt(10);
        this.posYDoubleAttack = random.nextInt(10);
        
        System.out.println("");
        tabuleiro();
    }
    
    public void tabuleiro(){
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(heroi.getPosX()==i && heroi.getPosY()==j){
                    System.out.print("H");
                    System.out.print(" ");
                }else if(vilao.getPosX()==i && vilao.getPosY()==j){
                    System.out.print("V");
                    System.out.print(" ");
                }else if(posXDoubleAttack == i && posYDoubleAttack==j){
                    System.out.print("D");
                    System.out.print(" ");
                }else{
                    System.out.print("_");
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
    }
    
    public void movimento(){
        
        if(vilao.getVida() < vidaVilaoAnterrior){
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            while(x== heroi.getPosX() && y==heroi.getPosY()){
                x = random.nextInt(10);
                y = random.nextInt(10);
            }
            vidaVilaoAnterrior = vilao.getVida();
        }else {
            if(vilao.check(heroi)){
            
                if(heroi.isDoubleAttack()){
                    this.vidaVilaoAnterrior = vilao.getVida();
                    vilao.dano(2);
                    if(vilao.getVida() < 1){
                        System.out.println("");
                    }
                }else{
                    this.vidaVilaoAnterrior = vilao.getVida();
                    vilao.dano(1);
                }
            }
        }
        
    }
    
    public int[] Regras(){
        
        // A maior prioriadade vai pro mais proximo de zero
        // Regra 01: SE a vida do vilão atual é menor que vida do vilão anterior
        // ENTÃO colocar o vilão em posição aleatória
        // Regra 02: SE a posição atual for a mesma que a posição do vilão E a 
        // vida do vilão for zero ENTÃO vilão derrotado
        // Regra 03: SE a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão
        // Regra 03: SE a posição atual for a mesma que a posição do vilão
        // ENTÃO atacaro o vilão E o bonus estar ativo dar o DOBRO do dano
        // Regra 04: SE a posição atual for a mesma que a posição do bonus
        // ENTÃO ativar o bonus
        // Regra 05: SE o número da COLUNA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a ESQUERDA.
        // Regra 06: SE o número da COLUNA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a DIREIRA.
        // Regra 07: SE o número da LINHA da posição atual for INFERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a BAIXO.
        // Regra 08: SE o número da LINHA da posição atual for SUPERIOR ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a CIMA.
        
        // Regra 09: SE o número da coluna da posição atual for superior ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a esquerda.
        // Regra 10: SE o número da coluna da posição atual for superior ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a esquerda.
        // Regra 11: SE o número da coluna da posição atual for superior ao número
        // da coluna da posição do vilão ENTÃO dar um passo para a esquerda.
        
        
        return null;
    }
    
}
