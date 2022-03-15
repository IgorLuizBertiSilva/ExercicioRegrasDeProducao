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
public class Vilao {
    
    private int vida;
    private int posX;
    private int posY;

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.vida;
        hash = 89 * hash + this.posX;
        hash = 89 * hash + this.posY;
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
        final Vilao other = (Vilao) obj;
        if (this.vida != other.vida) {
            return false;
        }
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
        return "Vilao{" + "vida=" + vida + ", posX=" + posX + ", poxY=" + posY + '}';
    }

    public Vilao(int posX, int poxY) {
        this.vida = 3;
        this.posX = posX;
        this.posY = poxY;
    }

    public Vilao() {
        
    }
    
    public boolean check(Heroi heroi){
        return (heroi.getPosX() == posX && heroi.getPosY() == posY);
    }
    
    public void dano(int quantidade){
        this.vida = this.vida - quantidade;
    }
    
    public void teleporte(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
}
