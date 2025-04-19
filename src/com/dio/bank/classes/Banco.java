package com.dio.bank.classes;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome = "Banco DIO";
    private List<Conta> contas;

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Cliente cadastrarCliente(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome inválido.");
            return null;
        }

        return new Cliente(nome);
    }

    public boolean criarConta(Cliente cliente, String tipoConta) {
        if (cliente == null) {
            System.out.println("Conta inválida.");
            return false;
        }

        Conta conta;
        switch (tipoConta) {
            case "CC" -> {
                conta = new ContaCorrente(cliente);
                System.out.println("Conta Corrente criada com sucesso!");
            }
            case "CP" -> {
                conta = new ContaPoupanca(cliente);
                System.out.println("Conta Poupança criada com sucesso!");
            }
            default -> {
                System.out.println("Tipo de conta inválido.");
                return false;
            }
        }

        return adicionarConta(conta);

    }

    public boolean adicionarConta(Conta conta) {
        if (conta == null) {
            System.out.println("Conta inválida.");
            return false;
        }

        if (contas == null) {
            contas = new ArrayList<>();
        }

        contas.add(conta);
        return true;
    }

    public void listarContas() {
        if (contas == null || contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        }

        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getNomeCliente());
            System.out.println("Agência: " + conta.getAgencia());
            System.out.println("Número: " + conta.getNumero());
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("\n");
        }
    }
}
