public class Main {

    public static void main(String[] args) {
        Cliente fulano = new Cliente();
        fulano.setNome("Venilton");

        Banco banco = new Banco("Meu Banco");

        ContaCorrente cc = new ContaCorrente(fulano);
        ContaPoupanca poupanca = new ContaPoupanca(fulano);

        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        poupanca.calcularJuros(); // Calcula juros da poupança
        poupanca.depositarRendimento(); // Deposita o rendimento na poupança

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        System.out.println("Saldo total do banco: R$ " + banco.calcularSaldoTotal());
    }

}
