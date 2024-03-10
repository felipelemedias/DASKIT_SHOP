/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fleme
 */
public class Loja implements Sujeito {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void abrirLoja() {
        notifyObservers("A loja está aberta!");
    }

    public void fecharLoja() {
        notifyObservers("A loja está fechada!");
    }

    public void entrarCliente(String nomeCliente) {
        notifyObservers("O cliente " + nomeCliente + " entrou na loja.");
    }

    public void sairCliente(String nomeCliente) {
        notifyObservers("O cliente " + nomeCliente + " saiu da loja.");
    }
}

