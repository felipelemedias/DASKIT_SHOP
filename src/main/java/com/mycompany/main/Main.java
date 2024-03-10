/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.main;

/**
 *
 * @author fleme
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(new CartaoPagamento());

        // utilizando o padrao Singleton
        FabricanteCelular apple = FabricanteCelularSingleton.getInstance("apple");
        FabricanteCelular samsung = FabricanteCelularSingleton.getInstance("samsung");

        // utilizando o padrao Fabrica
        Celular iphones = apple.constroiCelular("iphones");
        Celular galaxy8 = samsung.constroiCelular("galaxy8");

        // Utilizando o padrão Decorator para adicionar o recurso FaceID aos celulares
        Celular iphonesComFaceID = new FaceIDDecorator(iphones);
        Celular galaxy8ComFaceID = new FaceIDDecorator(galaxy8);

        // Abrindo a loja
        loja.abrirLoja();

        while (true) {
            System.out.println("\n1. Cadastrar venda (cliente entrou na loja)");
            System.out.println("2. Encerrar venda (cliente saiu da loja)");
            System.out.println("3. Fechar loja");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.next();
                    loja.entrarCliente(nomeCliente);
                    System.out.println("1. Comprar iPhoneS");
                    System.out.println("2. Comprar iPhoneS com FaceID");
                    System.out.println("3. Comprar Galaxy8");
                    System.out.println("4. Comprar Galaxy8 com FaceID");
                    System.out.print("Escolha uma opção: ");
                    int opcaoCompra = scanner.nextInt();
                    switch (opcaoCompra) {
                        case 1:
                            carrinho.adicionarCelular(iphones);
                            break;
                        case 2:
                            carrinho.adicionarCelular(iphonesComFaceID);
                            break;
                        case 3:
                            carrinho.adicionarCelular(galaxy8);
                            break;
                        case 4:
                            carrinho.adicionarCelular(galaxy8ComFaceID);
                            break;
                    }
                    System.out.println("Total no carrinho agora é: R$" + carrinho.calcularTotal());
                    System.out.println("1. Pagar com cartão de crédito");
                    System.out.println("2. Pagar com PIX");
                    System.out.print("Escolha uma opção: ");
                    int opcaoPagamento = scanner.nextInt();
                    switch (opcaoPagamento) {
                        case 1:
                            carrinho.setPagamentoStrategy(new CartaoPagamento());
                            break;
                        case 2:
                            carrinho.setPagamentoStrategy(new PixPagamento());
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do cliente: ");
                    nomeCliente = scanner.next();
                    loja.sairCliente(nomeCliente);
                    System.out.println("Total a pagar: R$" + carrinho.calcularTotal());
                    carrinho.pagar();
                    break;
                case 3:
                    loja.fecharLoja();
                    System.exit(0);
            }
        }
    }
}
