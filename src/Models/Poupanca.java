package Models;

import Enums.TipoDeConta;

public class Poupanca extends Conta{
    public Poupanca(Cliente cliente) {
        super(cliente, TipoDeConta.Poupanca);
    }

    public void sacar(float valor){
        super.sacar(valor);
    }
}
