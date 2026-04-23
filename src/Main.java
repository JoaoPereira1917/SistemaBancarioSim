import Models.*;
import Repos.*;
import Enums.TipoDeConta;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContaRepository repository = new ContaRepository();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========== SISTEMA BANCÁRIO ==========");
            System.out.println("1. Criar Conta");
            System.out.println("2. Realizar Depósito");
            System.out.println("3. Realizar Saque");
            System.out.println("4. Realizar Transferência");
            System.out.println("5. Listar Contas");
            System.out.println("6. Calcular Total de Tributos");
            System.out.println("7. Sair");
            System.out.println("======================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("\n--- CRIAR CONTA ---");
                System.out.print("Nome do cliente: ");
                String nome = scanner.nextLine();
                System.out.print("CPF do cliente: ");
                int cpf = scanner.nextInt();

                System.out.println("Tipo de conta:");
                System.out.println("1. Conta Corrente");
                System.out.println("2. Conta Poupança");
                System.out.print("Escolha: ");
                int tipo = scanner.nextInt();

                Cliente cliente = new Cliente(nome, cpf);

                if (tipo == 1) {
                    Conta conta = new Corrente(cliente);
                    repository.AdicionarConta(conta);
                    System.out.println("Conta Corrente criada! Número: " + conta.getNumero());
                } else if (tipo == 2) {
                    Conta conta = new Poupanca(cliente);
                    repository.AdicionarConta(conta);
                    System.out.println("Conta Poupança criada! Número: " + conta.getNumero());
                } else {
                    System.out.println("Opção inválida!");
                }

            } else if (opcao == 2) {
                System.out.println("\n-- REALIZAR DEPÓSITO ---");
                System.out.print("Número da conta: ");
                int numero = scanner.nextInt();
                System.out.print("Valor: R$ ");
                float valor = scanner.nextFloat();
                repository.depositar(numero, valor);

            } else if (opcao == 3) {
                System.out.println("\n--- REALIZAR SAQUE ---");
                System.out.print("Número da conta: ");
                int numero = scanner.nextInt();
                System.out.print("Valor: R$ ");
                float valor = scanner.nextFloat();
                repository.sacar(numero, valor);

            } else if (opcao == 4) {
                System.out.println("\n--- REALIZAR TRANSFERÊNCIA--");
                System.out.print("Conta de origem: ");
                int origem = scanner.nextInt();
                System.out.print("Conta de destino: ");
                int destino = scanner.nextInt();
                System.out.print("Valor: R$ ");
                float valor = scanner.nextFloat();
                repository.transferir(origem, destino, valor);
            }
            else if (opcao == 5) {
                System.out.println("\n--- LISTA DE CONTAS ---");
                repository.listarContas();

            } else if (opcao == 6) {
                System.out.println("\n--- CÁLCULO DE TRIBUTOS---");
                repository.CalcularTributos();

            } else if (opcao == 7) {
                System.out.println("Encerrando..");
            } else {
                System.out.println("Opção inválida");
            }

        } while (opcao != 7);

        scanner.close();
    }
}