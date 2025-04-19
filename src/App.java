
import com.dio.bank.classes.Banco;
import com.dio.bank.classes.Cliente;
import com.dio.bank.classes.Conta;
import java.util.List;
import java.util.Random;

public class App {

    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();
        System.out.println("Bem-vindo ao " + banco.getNome() + "!");
        System.out.println("===================================");

        System.out.println("");
        System.out.println("Cadastrando clientes...");
        Cliente clienteJoao = banco.cadastrarCliente("João da Silva");
        Cliente clienteMaria = banco.cadastrarCliente("Maria Oliveira");
        Cliente clientePedro = banco.cadastrarCliente("Pedro Santos");
        Cliente clienteAna = banco.cadastrarCliente("Ana Costa");

        System.out.println("Cadastrando contas...");
        banco.criarConta(clienteJoao, "CC");
        banco.criarConta(clienteMaria, "CP");
        banco.criarConta(clientePedro, "CC");
        banco.criarConta(clienteAna, "CP");

        System.out.println("===================================");

        System.out.println("Listando contas...");
        banco.listarContas();

        System.out.println("===================================");

        System.out.println("Realizando operações aleatórias...");
        realizarOperacoesAleatorias(banco);

        System.out.println("\n===================================");
        System.out.println("Estado final das contas:");
        banco.listarContas();

        System.out.println("===================================");
        System.out.println("Imprimindo extratos detalhados:");
        for (Conta conta : banco.getContas()) {
            conta.imprimirExtrato();
            System.out.println();
        }
        System.out.println("===================================");
    }

    private static void realizarOperacoesAleatorias(Banco banco) {
        List<Conta> contas = banco.getContas();
        if (contas == null || contas.size() < 2) {
            System.out.println("Número insuficiente de contas para realizar operações.");
            return;
        }

        // Realizar 10 operações aleatórias
        for (int i = 0; i < 10; i++) {
            int indexOrigem = random.nextInt(contas.size());
            int indexDestino = random.nextInt(contas.size());

            while (indexDestino == indexOrigem) {
                indexDestino = random.nextInt(contas.size());
            }

            Conta contaOrigem = contas.get(indexOrigem);
            Conta contaDestino = contas.get(indexDestino);

            double valor = 1 + random.nextDouble() * 1000;
            valor = Math.round(valor * 100.0) / 100.0;

            // Escolhe operação aleatória (0 = depósito, 1 = saque, 2 = transferência)
            int operacao = random.nextInt(3);

            System.out.println("\nOperação " + (i + 1) + ":");
            switch (operacao) {
                case 0 -> {
                    System.out.printf("Depositando R$ %.2f na conta de %s%n",
                            valor, contaOrigem.getNomeCliente());
                    contaOrigem.depositar(valor);
                }
                case 1 -> {
                    System.out.printf("Sacando R$ %.2f da conta de %s%n",
                            valor, contaOrigem.getNomeCliente());
                    contaOrigem.sacar(valor);
                }
                case 2 -> {
                    System.out.printf("Transferindo R$ %.2f da conta de %s para %s%n",
                            valor, contaOrigem.getNomeCliente(), contaDestino.getNomeCliente());
                    contaOrigem.transferir(valor, contaDestino);
                }
            }
        }
    }
}
