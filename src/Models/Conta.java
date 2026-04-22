package Models;

public abstract class Conta {
    private static int proximoNumero = 101;
    private Cliente cliente;
    private float saldo;
    private int numero;
    public Conta(Cliente cliente){
        this.cliente = cliente;
        this.saldo = 0;
        this.numero = proximoNumero++;
    }

    public void depositar(float valor){}
    public void sacar(float valor){}
    public void transferir(int contaNumero, float valor){}

    private int gerarNumero(){}
}
