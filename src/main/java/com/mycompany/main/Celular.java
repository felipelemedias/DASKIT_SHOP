/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public interface Celular {
    public void fazLigacao();
    public void tiraFoto();
    public void faceID(); //adicionar funcionalidade com decorator
    public double getPreco(); //adicionar método para obter o preço
}
