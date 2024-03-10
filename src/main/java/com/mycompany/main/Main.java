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
        System.out.println("Preço do iPhoneS sem FaceID: R$" + iphones.getPreco());
        
        // Utilizando o padrão Decorator para adicionar o recurso FaceID ao iPhoneS
        Celular iphonesComFaceID = new FaceIDDecorator(iphones);
        System.out.println("Preço do iPhoneS com FaceID: R$" + iphonesComFaceID.getPreco());

        // utilizando o padrao Singleton
        FabricanteCelular samsung = FabricanteCelularSingleton.getInstance("samsung");

        // utilizando o padrao Fabrica
        Celular galaxy8 = samsung.constroiCelular("galaxy8");
        System.out.println("Preço do Galaxy8 sem FaceID: R$" + galaxy8.getPreco());

        // Utilizando o padrão Decorator para adicionar o recurso FaceID ao Galaxy8
        Celular galaxy8ComFaceID = new FaceIDDecorator(galaxy8);
        System.out.println("Preço do Galaxy8 com FaceID: R$" + galaxy8ComFaceID.getPreco());
        
        // Criando um carrinho de compras com a estratégia de pagamento por cartão de crédito
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(new CartaoPagamento());
        
        // Adicionando os celulares ao carrinho
        carrinho.adicionarCelular(iphonesComFaceID);
        System.out.println("Adicionado iPhoneS com FaceID ao carrinho. Total agora é: R$" + carrinho.calcularTotal());
        
        carrinho.adicionarCelular(galaxy8ComFaceID);
        System.out.println("Adicionado Galaxy8 com FaceID ao carrinho. Total agora é: R$" + carrinho.calcularTotal());
        
        // Pagando os itens no carrinho com a estratégia de pagamento definida
        System.out.println("Total a pagar com cartão de crédito: R$" + carrinho.calcularTotal());
        carrinho.pagar();
        
        // Mudando a estratégia de pagamento para PIX e pagando novamente
        carrinho.setPagamentoStrategy(new PixPagamento());
        System.out.println("Total a pagar com PIX (com desconto): R$" + carrinho.calcularTotal());
        carrinho.pagar();
    }
}
