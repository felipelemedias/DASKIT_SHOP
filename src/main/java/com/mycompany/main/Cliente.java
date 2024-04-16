/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class Cliente implements Observer {

    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String message) {
        System.out.println("Cliente " + nome + " recebeu a atualização: " + message);
    }

    public String getNome() {
        return this.nome;  // Make sure this method is properly implemented.

    }
}
