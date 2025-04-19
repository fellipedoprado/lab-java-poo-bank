# Sistema Bancário Digital

## Introdução

Este projeto é uma implementação em Java de um sistema bancário digital, desenvolvido como parte do bootcamp da Digital Innovation One. O sistema simula operações bancárias básicas utilizando conceitos avançados de Programação Orientada a Objetos (POO).

O projeto foi construído com foco em boas práticas de programação, demonstrando a aplicação prática de conceitos como herança, polimorfismo, encapsulamento e abstração. Além disso, implementa funcionalidades comuns de um sistema bancário como criação de contas, transferências, depósitos e saques.

### Tecnologias Utilizadas
- Java 21

### Principais Características
- Sistema modular e extensível
- Código limpo e bem documentado
- Fácil manutenção e expansão

## Estrutura de Pastas

O workspace contém duas pastas por padrão:

- src: pasta para manter o código fonte
- lib: pasta para manter as dependências

Os arquivos compilados serão gerados na pasta bin por padrão.


## Sobre o Projeto

Este projeto implementa um sistema bancário digital com funcionalidades como:
- Gerenciamento de contas (Corrente e Poupança)
- Cadastro de clientes
- Histórico de transações
- Simulação de operações aleatórias

### Funcionalidades Principais

- Criação e gerenciamento de contas
- Suporte a múltiplos tipos de conta
- Histórico de transações
- Operações bancárias básicas (depósito, saque, transferência)
- Operações aleatórias automatizadas para testes

## Implementação Técnica

### Conceitos de POO Utilizados

1. **Herança**
   - `Conta` como classe base abstrata
   - `ContaCorrente` e `ContaPoupanca` como classes especializadas

2. **Encapsulamento**
   - Atributos privados com getters/setters públicos
   - Métodos protegidos para uso interno das classes

3. **Abstração**
   - Interface `IConta` definindo comportamentos da conta
   - Métodos abstratos nas classes base

4. **Polimorfismo**
   - Diferentes tipos de conta implementando a mesma interface
   - Sobrescrita de métodos para implementações específicas

### Estrutura de Classes

```
com.dio.bank
├── classes
│   ├── Banco
│   ├── Cliente
│   ├── Conta (abstrata)
│   ├── ContaCorrente
│   ├── ContaPoupanca
│   └── Transacao
└── interfaces
    └── IConta
```

## Como Executar

1. Clone o repositório
```bash
git clone <url-do-repositorio>
```

2. Navegue até o diretório do projeto
```bash
cd lab-java-poo-bank
```

3. Compile o projeto
```bash
javac -d bin src/com/dio/bank/classes/*.java src/com/dio/bank/interfaces/*.java src/App.java
```

4. Execute a aplicação
```bash
java -cp bin App
```

## Exemplo de Uso

```java
// Criar uma instância do banco
Banco banco = new Banco();

// Cadastrar clientes
Cliente cliente = banco.cadastrarCliente("João da Silva");

// Criar contas
banco.criarConta(cliente, "CC"); // Cria conta corrente
banco.criarConta(cliente, "CP"); // Cria conta poupança

// Realizar operações
banco.listarContas();
```
