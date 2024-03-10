/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class IphoneS implements Celular {
    private double preco;

    public IphoneS(double preco) {
        this.preco = preco;
    }
    
    @Override
    public void fazLigacao() {
        System.out.println("IphoneS fazendo ligação..");
    }

    @Override
    public void tiraFoto() {
        System.out.println("IphoneS tirando foto..");
    }
    
    @Override
    public void faceID() {
        System.out.println("IphoneS não suporta faceID..");
    }
    
    @Override
    public double getPreco() {
        return this.preco;
    }
    
}
