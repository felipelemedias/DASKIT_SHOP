/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class FaceIDDecorator extends CelularDecorator {
    private static final double CUSTO_EXTRA = 500.0;  // Custo extra para adicionar o FaceID

    public FaceIDDecorator(Celular celular) {
        super(celular);
    }

    @Override
    public void faceID() {
        super.faceID();
        System.out.println("FaceID adquirido com sucesso(custo extra de R$500.00).");
    }

    @Override
    public double getPreco() {
        return super.getPreco() + CUSTO_EXTRA;
    }
}

