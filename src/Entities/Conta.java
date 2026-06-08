package Entities;

import Entities.Enums.TipoTransacao;
import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int numeroConta;
    private String nomeTitular;
    private double saldo;
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta(int numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public Conta(int numeroConta, String nomeTitular, double depositoInicial) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        deposito(depositoInicial);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public double deposito(double valorDeposito) {
        transacoes.add(new Transacao(TipoTransacao.DEPOSITO, valorDeposito));
        return saldo += valorDeposito;
    }

    public double saque(double valorSaque) {
        transacoes.add(new Transacao(TipoTransacao.SAQUE, valorSaque));
        return saldo -= (valorSaque + 5.00);
    }

    public String gerarExtrato() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%n================ EXTRATO BANCÁRIO ================%n"));
        sb.append(String.format("Conta: %-6d | Titular: %s%n", numeroConta, nomeTitular));
        sb.append(String.format("--------------------------------------------------%n"));
        if (transacoes.isEmpty()) {
            sb.append(String.format("Não há movimentações registradas.%n"));
        } else {
            for (Transacao t : transacoes) {
                sb.append(t.toString()).append(System.lineSeparator());
            }
        }
        sb.append(String.format("--------------------------------------------------%n"));
        sb.append(String.format("Saldo Atual: R$ %.2f%n", saldo));
        sb.append(String.format("==================================================%n"));
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("Número da conta: %d, titular: %s, saldo atual: R$ %.2f", numeroConta, nomeTitular, saldo);
    }
}

