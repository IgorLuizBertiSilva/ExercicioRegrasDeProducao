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
                }else if(vilao.getPosX()==i && vilao.getPoxY()==j){
                    System.out.print("V");
                    System.out.print(" ");
                }else {
                    System.out.print("_");
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        
    }
    
}
