package Interfaces;

import Models.Conta;

import java.util.List;

public interface IContaRepository{
    public void AdicionarConta(Conta conta);
    public void listarContas();
    public void depositar(int numeroConta, float valor);
    public void sacar(int numeroConta, float valor);
    public void transferir(int numeroContaOrigem, int numeroContaDestino, float valor);
    public void CalcularTributos();
}
