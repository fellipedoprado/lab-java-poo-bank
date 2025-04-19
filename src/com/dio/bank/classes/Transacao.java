package com.dio.bank.classes;

import java.time.LocalDateTime;

public class Transacao {
    private LocalDateTime dataHora;
    private String tipo;
    private double valor;
    private String descricao;

    public Transacao(String tipo, double valor, double saldoResultante, String descricao) {
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
