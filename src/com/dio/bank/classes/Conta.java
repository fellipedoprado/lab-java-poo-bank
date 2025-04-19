package com.dio.bank.classes;

import com.dio.bank.interfaces.IConta;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    private List<Transacao> transacoes;

    public Conta() {
        this.transacoes = new ArrayList<>();
    }

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.transacoes = new ArrayList<>();
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        registrarTransacao("SAQUE", valor, "Saque em conta");
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        registrarTransacao("DEPOSITO", valor, "Depósito em conta");
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        registrarTransacao("TRANSFERENCIA", valor, "Transferência de conta");
        contaDestino.registrarTransacao("TRANSFERENCIA", valor, "Depósito em conta");
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNomeCliente() {
        return cliente.getNome();
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

        for (Transacao transacao : transacoes) {
            System.out.println("========================================");
            System.out.println(String.format("Data: %s", transacao.getDataHora()));
            System.out.println(String.format("Tipo: %s", transacao.getTipo()));
            System.out.println(String.format("Valor: %s", transacao.getValor()));
            System.out.println(String.format("Descrição: %s", transacao.getDescricao()));
            System.out.println("========================================");
        }

    }

    @Override
    public void registrarTransacao(String tipo, double valor, String descricao) {
        Transacao transacao = new Transacao(tipo, valor, this.saldo, descricao);
        this.transacoes.add(transacao);
    }

    public List<Transacao> getExtrato() {
        return new ArrayList<>(transacoes);
    }

}
