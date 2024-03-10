/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
public class PixPagamento implements PagamentoStrategy {
    private static final double DESCONTO = 0.10;  // 10% de desconto

    @Override
    public void pagar(double valor) {
        double valorComDesconto = valor * (1 - DESCONTO);
        System.out.println("Pagando R$" + valorComDesconto + " com PIX (desconto de 10% aplicado).");
    }
}
