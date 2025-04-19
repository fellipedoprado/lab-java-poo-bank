package com.dio.bank.interfaces;

public interface IConta {

    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();

    void registrarTransacao(String tipo, double valor, String descricao);
}
