package Models;

import Enums.TipoDeConta;

public class Corrente extends Conta{
    public Corrente(Cliente cliente) {
        super(cliente, TipoDeConta.Corrente);

    }

    @Override public void sacar(float valor){
        double taxa = valor * 0.05;
        if(saldo - taxa + valor >= 0){
            saldo -= taxa + valor;
        }
        else {
            throw new RuntimeException("Saldo insuficiente");
        }

    }
}
