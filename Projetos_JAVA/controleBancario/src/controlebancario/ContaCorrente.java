package controlebancario;
public class ContaCorrente extends Conta{
    double valorSaque = 50;

    public ContaCorrente(int numero, int agencia, Cliente cliente) {
        super(numero, agencia, cliente);
    }

    @Override
    public void sacar(){
        if (this.getNumero() == 0 || this.getAgencia() == 0){
             System.out.println("********************************************");
             System.out.println("*              CONTA INVÁLIDA              *");
             System.out.println("********************************************");
        }else{
            double valorTaxa = 0.10;
            String saqueFormatado = String.format("%.2f", valorSaque);
            String saldoFormatado = String.format("%.2f", saldo);//**
            String taxaFormatada = String.format("%.2f", valorTaxa);
            if (this.getSaldo() < this.valorSaque){
                System.out.println("!   SALDO INSUFICIENTE PARA SAQUES   !");
            }else{
                
                this.saldo -= this.valorSaque -(-0.10);
                System.out.println("\n********************************************");
                System.out.println("°          [ SAQUE  C. CORRENTE ]          °");
                System.out.println("Conta: "+this.getNumero()+"                         Agência: "+this.getAgencia());
                System.out.println("DESCRIÇÃO..........................VALOR(R$)");
                System.out.println("SAQUE.................................."+ saqueFormatado +"          ");
                System.out.println("TAXA SAQUE.............................." + taxaFormatada );
                System.out.println("--------------------------------------------");
                System.out.print("SALDO ANTERIOR........................"+saldoFormatado);//**
                System.out.print("\nSALDO ATUAL...........................");
                System.out.format("%.2f",getSaldo());
                System.out.println("\n********************************************");
            }
        }
    }

    public double getValorSaque() {
        return valorSaque;
    }
    public void setValorSaque(double valorSaque) {
        this.valorSaque = valorSaque;
    }
}//fim classe ContaCorrente

/*
Conta corrente 
*- Deverá herdar de conta;
- Deverá retirar do saldo 0,10 a cada saque;
- Não deverá permitir sacar um valor superior ao saldo;
*/

/*
Conta:
- Número da conta e agência deverá ser maior que 0;
- Deverá ter um construtor com número, agência e cliente;
- Deverá iniciar um saldo 0;
- Deverá ter um método de sacar e depositar;
- O atributo saldo deverá ter apenas método get;
- O método sacar deverá ser abstrato;
*/