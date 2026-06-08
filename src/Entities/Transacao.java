package Entities;

import Entities.Enums.TipoTransacao;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private TipoTransacao tipo;
    private double valor;
    private LocalDateTime momento;

    public Transacao(TipoTransacao tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.momento = LocalDateTime.now();
    }

    public Transacao(TipoTransacao tipo, double valor, LocalDateTime momento) {
        this.tipo = tipo;
        this.valor = valor;
        this.momento = momento;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getMomento() {
        return momento;
    }

    @Override
    public String toString() {
        String sinal = (tipo == TipoTransacao.DEPOSITO) ? "+" : "-";
        return String.format("[%s] %-8s: %sR$ %.2f", momento.format(formatter), tipo, sinal, valor);
    }
}
