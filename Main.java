
package com.mycompany.main;

import java.util.Scanner;

class ContaBancaria {
    private String nomePessoa;
    private int numeroConta;
    private double saldo;

    // Construtor
    public ContaBancaria(String nomePessoa, int numeroConta, double saldoInicial) {
        this.nomePessoa = nomePessoa;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    // Método para depositar valor
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
    }

    // Método para sacar valor
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        }
    }

    // Método para obter saldo disponível
    public void obterSaldo() {
        System.out.println("Saldo disponível: R$ " + saldo);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Informe o número da conta:");
        int numeroConta = scanner.nextInt();

        System.out.println("Informe o saldo inicial:");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);
        System.out.println("Conta bancária criada com sucesso.");

        char opcao;
        do {
            System.out.println("\nEscolha a operação:");
            System.out.println("D - Depositar");
            System.out.println("S - Sacar");
            System.out.println("O - Obter saldo");
            System.out.println("Q - Sair");

            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case 'D':
                case 'd':
                    System.out.println("Informe o valor a depositar:");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 'S':
                case 's':
                    System.out.println("Informe o valor a sacar:");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 'O':
                case 'o':
                    conta.obterSaldo();
                    break;
                case 'Q':
                case 'q':
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 'Q' && opcao != 'q');

        scanner.close();
    }
}


