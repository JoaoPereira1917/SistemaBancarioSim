package Repos;

import Enums.TipoDeConta;
import Interfaces.IContaRepository;
import Models.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository implements IContaRepository {
    List<Conta> listaContas= new ArrayList<>();

    @Override
    public void AdicionarConta(Conta conta) {
        if(!(listaContas.contains(conta))){
            listaContas.add(conta);
        }
        else{
            throw new IllegalArgumentException("Conta já cadastrado");
        }

    }


    public void depositar(int numeroConta, float valor) {
        for (Conta conta : listaContas) {
            if (conta.getNumero() == numeroConta) {
                conta.depositar(valor);
                System.out.println("Depósito realizado com sucesso");
                return;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada!");
    }


    public void sacar(int numeroConta, float valor) {
        for (Conta conta : listaContas) {
            if (conta.getNumero() == numeroConta) {
                conta.sacar(valor);
                System.out.println("Saque realizado com sucesso");
                return;
            }
        }
        throw new IllegalArgumentException("Conta não encontrada!");

    }


    public void transferir(int numeroContaOrigem, int numeroContaDestino, float valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : listaContas) {
            if (conta.getNumero() == numeroContaOrigem) {
                contaOrigem = conta;
            }
            if (conta.getNumero() == numeroContaDestino) {
                contaDestino = conta;
            }
        }

        if (contaOrigem == null) {
            throw new IllegalArgumentException("Conta de origem não encontrada!");
        }
        if (contaDestino == null) {
            throw new IllegalArgumentException("Conta de destin não encontrada!");
        }
        contaOrigem.transferir(contaDestino, valor);
        System.out.println("Transferencia realizada com sucesso!");
    }


    public void listarContas() {
        for(Conta conta : listaContas) {
            System.out.println(conta);
        }
    }


    public void CalcularTributos() {
        double total = 0;
        for(Conta conta : listaContas) {
            if(conta.getTipoDeConta() == TipoDeConta.Corrente) {
                double tributo = conta.getSaldo() * 0.01;
                total += tributo;
                System.out.printf("Conta %d: R$ %.2f (1%% do saldo R$ %.2f)%n",
                        conta.getNumero(), tributo, conta.getSaldo());
            }
        }
        System.out.printf("Total de tributos: R$ %.2f%n", total);
    }
}
