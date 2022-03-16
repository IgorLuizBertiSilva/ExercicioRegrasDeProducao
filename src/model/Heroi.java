/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Aluno
 */
public class Heroi {
    
    private int posX;
    private int posY;
    private boolean doubleAttack;

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isDoubleAttack() {
        return doubleAttack;
    }

    public void setDoubleAttack(boolean doubleAttack) {
        this.doubleAttack = doubleAttack;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.posX;
        hash = 67 * hash + this.posY;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Heroi other = (Heroi) obj;
        if (this.posX != other.posX) {
            return false;
        }
        if (this.posY != other.posY) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Heroi{" + "posX=" + posX + ", posY=" + posY + ", doubleAttack=" + doubleAttack + '}';
    }

    public Heroi(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.doubleAttack = false;
    }

    public Heroi() {
        this.doubleAttack = false;
    }
    
    
    public void move(String direcao){
        
        if("esquerda".equals(direcao)){
            posX = posX - 1;
        }
        if("direita".equals(direcao)){
            posX = posX + 1;
        }
        
        if("cima".equals(direcao)){
            posY = posY - 1;
        }
        
        if("baixo".equals(direcao)){
            posY = posY +
                    1;
        }
        
        
    }
    
}
