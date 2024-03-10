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
public class CarrinhoDeCompras {
    private List<Celular> celulares;
    private PagamentoStrategy pagamentoStrategy;

    public CarrinhoDeCompras(PagamentoStrategy pagamentoStrategy) {
        this.celulares = new ArrayList<>();
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void adicionarCelular(Celular celular) {
        celulares.add(celular);
    }

    public void removerCelular(Celular celular) {
        celulares.remove(celular);
    }

    public double calcularTotal() {
        double total = 0;
        for (Celular celular : celulares) {
            total += celular.getPreco();
        }
        return total;
    }

    public void pagar() {
        double total = calcularTotal();
        pagamentoStrategy.pagar(total);
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }
}