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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loja implements Sujeito {

    private List<Observer> observers = new ArrayList<>();
    private Map<String, Integer> vendasPorModelo = new HashMap<>();
    private double faturamentoTotal = 0;

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
        vendasPorModelo.clear();
        faturamentoTotal = 0;
    }

    public void fecharLoja() {
        notifyObservers("A loja está fechada!");
        System.out.println("Relatório de Vendas:");
        vendasPorModelo.forEach((modelo, quantidade)
                -> System.out.println(modelo + ": " + quantidade + " unidades vendidas."));
        System.out.println("Faturamento total: R$" + faturamentoTotal);
    }

    public void registrarVenda(String modelo, double preco) {
        vendasPorModelo.put(modelo, vendasPorModelo.getOrDefault(modelo, 0) + 1);
        faturamentoTotal += preco;
    }

    public void entrarCliente(String nomeCliente) {
        notifyObservers("O cliente " + nomeCliente + " entrou na loja.");
    }

    public void sairCliente(String nomeCliente) {
        notifyObservers("O cliente " + nomeCliente + " saiu da loja.");
    
    }
}
