package Models;

import Enums.TipoDeConta;

public abstract class Conta {
    private static int proximoNumero = 101;
    private Cliente cliente;
    protected TipoDeConta tipoDeConta;
    protected float saldo;
    private int numero;
    public Conta(Cliente cliente, TipoDeConta tipoDeConta) {
        this.cliente = cliente;
        this.saldo = 0;
        this.numero = proximoNumero++;
        this.tipoDeConta = tipoDeConta;
    }

    public void depositar(float valor){
        this.saldo += valor;
    }
    public void sacar(float valor){
        if(valor > saldo){
            throw  new RuntimeException("Saldo insuficiente");
        }
        saldo -= valor;

    }
    public void transferir(Conta contaDestino, float valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
    }

    @Override
    public String toString(){
        return ("Numero da conta: " + numero +"Tipo: "+ tipoDeConta + "Cliente: " + cliente.getNome()+ "Saldo: " + saldo);
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public TipoDeConta getTipoDeConta() {
        return tipoDeConta;
    }
    public float getSaldo() {
        return saldo;
    }



}
