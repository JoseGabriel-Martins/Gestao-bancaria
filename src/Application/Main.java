package Application;

import Entities.Conta;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Conta> contas = new ArrayList<>();

        int numeroConta = contas.size();

        try {
            System.out.println("Criar conta:");
            System.out.println("---------------");
            System.out.println("Número da conta: " + numeroConta);
            System.out.println("Informe o nome do titular da conta: ");
            String titularConta = sc.nextLine();

            System.out.println("Realizar um depósito inicial S/N? ");
            char respostaDeposito = sc.nextLine().toUpperCase().charAt(0);

            if (respostaDeposito == 'S') {
                System.out.println("Digite o valor a ser depositado: ");
                double valorDeposito = sc.nextDouble();
                sc.nextLine();
                Conta contaNova = new Conta(numeroConta, titularConta, valorDeposito);
                contas.add(contaNova);
            } else {
                System.out.println("Como não houve depósito no momento de criação da conta, o saldo inicial será: 0 ");
                Conta contanova = new Conta(numeroConta, titularConta);
                contas.add(contanova);
            }

            int opcao = 0;
            Conta contaAtiva = contas.stream().filter(x -> x.getNumeroConta() == numeroConta).findFirst().orElse(null);

            if (contaAtiva != null) {
                while (opcao != 4) {
                    System.out.println("\nEscolha uma opção:");
                    System.out.println("1 - Extrato Detalhado");
                    System.out.println("2 - Depositar");
                    System.out.println("3 - Sacar");
                    System.out.println("4 - Sair");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println(contaAtiva.gerarExtrato());
                            break;
                        case 2:
                            System.out.println("Digite o valor a ser depositado: ");
                            double valorDep = sc.nextDouble();
                            contaAtiva.deposito(valorDep);
                            System.out.println("Depósito realizado com sucesso!");
                            System.out.printf("Saldo atual: R$ %.2f %n", contaAtiva.getSaldo());
                            break;
                        case 3:
                            System.out.println("Digite o valor a ser sacado: ");
                            double valorSaque = sc.nextDouble();
                            contaAtiva.saque(valorSaque);
                            System.out.println("Saque realizado com sucesso! (Taxa de R$ 5.00 cobrada)");
                            System.out.printf("Saldo atual: R$ %.2f %n", contaAtiva.getSaldo());
                            break;
                    }
                }
            } else {
                System.out.println("Erro crítico: conta não encontrada.");
            }
            System.out.println("Até logo!");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida! Por favor, digite os dados corretamente.");
        } catch (NullPointerException e) {
            System.out.println("Erro: Tentativa de acessar um dado nulo.");
        } finally {
            sc.close();
        }
    }
}
