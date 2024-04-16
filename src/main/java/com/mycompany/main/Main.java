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

    private static Loja loja = new Loja();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        boolean lojaAberta = false;

        while (running) {
            System.out.println("\n--- Loja de Celulares ---");
            System.out.println("1. Abrir Loja");
            System.out.println("2. Comprar Celular");
            System.out.println("3. Fechar Loja");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (choice) {
                case 1:
                    if (!lojaAberta) {
                        loja.abrirLoja();
                        lojaAberta = true;
                        System.out.println("A loja está aberta.");
                    } else {
                        System.out.println("A loja já está aberta.");
                    }
                    break;
                case 2:
                    if (lojaAberta) {
                        realizarCompra();
                    } else {
                        System.out.println("A loja está fechada. Por favor, abra a loja primeiro.");
                    }
                    break;
                case 3:
                    if (lojaAberta) {
                        loja.fecharLoja();
                        lojaAberta = false;
                    } else {
                        System.out.println("A loja já está fechada.");
                    }
                    break;
                case 4:
                    if (lojaAberta) {
                        loja.fecharLoja();
                    }
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    private static void realizarCompra() {
        System.out.println("Por favor, digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = new Cliente(nomeCliente);
        loja.registerObserver(cliente);
        loja.entrarCliente(cliente.getNome());

        boolean continuarCompras = true;
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras(new PixPagamento()); // Default to PIX for initial setup

        while (continuarCompras) {
            System.out.println("Escolha um fabricante ('apple' ou 'samsung'):");
            String tipo = scanner.nextLine().toLowerCase();

            if (!tipo.equals("apple") && !tipo.equals("samsung")) {
                System.out.println("Fabricante inválido. Por favor, escolha 'apple' ou 'samsung'.");
                continue;
            }

            FabricanteCelular fabricante = FabricanteCelularSingleton.getInstance(tipo);
            String[] modelosDisponiveis;
            if ("apple".equals(tipo)) {
                modelosDisponiveis = new String[]{"iphones"};
                System.out.println("Modelos disponíveis: iphones");
            } else {
                modelosDisponiveis = new String[]{"galaxy8"};
                System.out.println("Modelos disponíveis: galaxy8");
            }

            System.out.println("Informe o modelo desejado:");
            String modelo = scanner.nextLine().toLowerCase();
            if (!java.util.Arrays.asList(modelosDisponiveis).contains(modelo)) {
                System.out.println("Modelo não disponível para o fabricante selecionado.");
                continue;
            }

            Celular celular = fabricante.constroiCelular(modelo);
            if (celular == null) {
                System.out.println("Erro ao construir o modelo. Por favor, tente novamente.");
                continue;
            }

            System.out.println("Deseja adicionar FaceID por R$500.00? (sim/não)");
            String resposta = scanner.nextLine().toLowerCase();

            if ("sim".equals(resposta)) {
                celular = new FaceIDDecorator(celular);
            }

            carrinho.adicionarCelular(celular);
            loja.registrarVenda(modelo, celular.getPreco());
            System.out.println("Produto adicionado ao carrinho.");

            System.out.println("Deseja adicionar mais produtos? (sim/não)");
            resposta = scanner.nextLine().toLowerCase();
            if ("não".equals(resposta) || "no".equals(resposta) || "nao".equals(resposta)) {
                continuarCompras = false;
            }
        }

        System.out.println("Escolha a forma de pagamento ('pix' ou 'cartao'):");
        String formaPagamento = scanner.nextLine().toLowerCase();
        PagamentoStrategy pagamentoStrategy = "pix".equals(formaPagamento) ? new PixPagamento() : new CartaoPagamento();
        carrinho.setPagamentoStrategy(pagamentoStrategy);

        System.out.println("Finalizando a compra...");
        carrinho.pagar();
        System.out.println("Compra realizada com sucesso!");

        loja.removeObserver(cliente);  // Remove observer after purchase
        loja.sairCliente(cliente.getNome());

    }
}
