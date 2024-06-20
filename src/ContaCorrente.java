public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;
    private double taxaManutencaoMensal;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.limiteChequeEspecial = 0;
        this.taxaManutencaoMensal = 10.0;
    }

    public ContaCorrente(Cliente cliente, double saldoInicial, double limiteChequeEspecial, double taxaManutencaoMensal) {
        super(cliente);
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.taxaManutencaoMensal = taxaManutencaoMensal;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void calcularJuros() {

        double taxaJuros = 0.5;
        double juros = saldo * (taxaJuros / 100);
        saldo += juros;
        System.out.printf("Juros de R$ %.2f aplicados à conta corrente.%n", juros);
    }

    public void cobrarTaxaManutencao() {
        saldo -= taxaManutencaoMensal;
        System.out.printf("Taxa de manutenção de R$ %.2f cobrada.%n", taxaManutencaoMensal);
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo + limiteChequeEspecial) {
                saldo -= valor;
                System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
            } else {
                System.out.println("Saldo insuficiente. Saque não realizado.");
            }
        } else {
            System.out.println("Valor inválido para saque.");
        }
    }

}
