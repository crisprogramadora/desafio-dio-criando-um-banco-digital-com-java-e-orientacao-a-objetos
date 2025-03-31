public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Deposito realizado com sucesso!");
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        System.out.println("Saque realizado com sucesso!");
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferência realizada com sucesso!");
    }

    @Override
    public void efeturarPagamento(String beneficiario, double valorPagamento) {
        if (valorPagamento > saldo) {
            System.out.println("Saldo insuficiente para pagar a conta.");
        } else {
            this.saldo -= valorPagamento;
            System.out.println("Pagamento efetuado com sucesso!");
        }
        
    }


    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
