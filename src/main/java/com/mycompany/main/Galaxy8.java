/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class Galaxy8 implements Celular {
    private double preco;

    public Galaxy8(double preco) {
        this.preco = preco;
    }

    @Override
    public void fazLigacao() {
        System.out.println("Galaxy8 fazendo ligação..");
    }

    @Override
    public void tiraFoto() {
        System.out.println("Galaxy8 tirando foto..");
    }
    
    @Override
    public void faceID() {
        System.out.println("Galaxy 8 não suporta faceID..");
    }

    @Override
    public double getPreco() {
        return this.preco;
    }
}
