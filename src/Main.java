public class Main {
    public static void main(String[] args) {
        Cliente cristiane = new Cliente();
        cristiane.setNome("Cristiane");
        cristiane.setCpf("12345678900");
        cristiane.setEndereco("Rua das Flores, 123");
        cristiane.setTelefone(123456789);

        Conta cc = new ContaCorrente(cristiane);

        Conta poupanca = new ContaPoupanca(cristiane);

        cc.imprimirExtrato();

        poupanca.imprimirExtrato();

        cc.depositar(1000);

        cc.sacar(50);

        cc.transferir(100, poupanca);
        
        cc.efeturarPagamento("Conta de Luz", 200);

        cc.imprimirExtrato();
        
        poupanca.imprimirExtrato();
    }
}
