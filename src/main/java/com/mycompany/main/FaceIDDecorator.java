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
    public FaceIDDecorator(Celular celular) {
        super(celular);
    }

    @Override
    public void faceID() {
        System.out.println("Recurso FaceID adquirido.");
    }
}
