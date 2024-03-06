/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class Main {

    public static void main(String [] args ) {
        
        // utilizando o padrao Singleton
        FabricanteCelular apple = FabricanteCelularSingleton.getInstance("apple");

        // utilizando o padrao Fabrica
        Celular iphones = apple.constroiCelular("iphones");
        
        // Utilizando o padrão Decorator para adicionar o recurso FaceID ao iPhoneS
        Celular iphonesComFaceID = new FaceIDDecorator(iphones);
        
        System.out.println("ok iPhoneS de fábrica sem FaceID");
        // utilizando o celular fabricado para implementar FaceID com decorator
        iphonesComFaceID.tiraFoto();
        iphonesComFaceID.fazLigacao();
        iphonesComFaceID.faceID();
        System.out.println("ok iPhoneS com FaceID");

        // utilizando o padrao Singleton
        FabricanteCelular samsung = FabricanteCelularSingleton.getInstance("samsung");

        // utilizando o padrao Fabrica
        Celular galaxy8 = samsung.constroiCelular("galaxy8");

        // Utilizando o padrão Decorator para adicionar o recurso FaceID ao Galaxy8
        Celular galaxy8ComFaceID = new FaceIDDecorator(galaxy8);
        
        System.out.println("ok Galaxy8 de fábrica sem FaceID");
        // utilizando o celular fabricado para implementar FaceID com decorator
        galaxy8ComFaceID.tiraFoto();
        galaxy8ComFaceID.fazLigacao();
        galaxy8ComFaceID.faceID();
        System.out.println("ok Galaxy8 com FaceID");
        
    }
}