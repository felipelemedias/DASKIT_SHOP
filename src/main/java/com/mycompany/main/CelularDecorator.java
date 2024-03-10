/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class CelularDecorator implements Celular {
    private Celular celular;

    public CelularDecorator(Celular celular) {
        this.celular = celular;
    }

    @Override
    public void fazLigacao() {
        celular.fazLigacao();
    }

    @Override
    public void tiraFoto() {
        celular.tiraFoto();
    }

    @Override
    public void faceID() {
        celular.faceID();
    }
    
    @Override
    public double getPreco() {
        return celular.getPreco();
    }
}
