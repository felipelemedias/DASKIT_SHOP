/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class Apple implements FabricanteCelular {
    
    @Override
    public Celular constroiCelular(String modelo){
        if(modelo.equals("iphones")){
            return new IphoneS(4999.99);
        }
        return null;
    }
}
