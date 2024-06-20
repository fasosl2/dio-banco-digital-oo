public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.taxaRendimento = 0.5;
    }

    public ContaPoupanca(Cliente cliente, double saldoInicial, double taxaRendimento) {
        super(cliente);
        this.saldo = saldoInicial;
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }

    @Override
    public void calcularJuros() {
        double rendimentoMensal = saldo * (taxaRendimento / 12) / 100;
        saldo += rendimentoMensal;
        System.out.printf("Rendimento de R$ %.2f aplicado à conta poupança.%n", rendimentoMensal);
    }

    public void depositarRendimento() {
        saldo += saldo * (taxaRendimento / 100);
        System.out.println("Rendimento mensal aplicado à conta poupança.");
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

}
