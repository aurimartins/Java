package controlebancario;
public abstract class Conta {
    private int numero;
    private int agencia;
    private Cliente cliente;
    protected double saldo = 0;

    public Conta(int numero, int agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
    }
    
    public void criarConta(){
        if (this.numero == 0 || this.agencia == 0){
            System.out.println("********************************************");
            System.out.println("*              CONTA INVÁLIDA              *");
            System.out.println("********************************************");
            }if (this.numero==0){
                System.out.println("O Número da conta deve ser MAIOR QUE ZERO! ");
            }if(this.agencia==0){
                System.out.println("O Número de Agência deve ser MAIOR QUE ZERO! ");
                System.out.println("--------------------------------------------");
            }else{
                System.out.println("--------------------------------------------");
                System.out.println("!         CONTA CRIADA COM SUCESSO         !");
                System.out.println("--------------------------------------------");
        }
    }
    
    public void depositar(double valor, Cliente cliente){
        if(this.getNumero()==0 || this.getAgencia()==0){
        }else{
            String saldoFormatado = String.format("%.2f", saldo);//
            String valorFormatado = String.format("%.2f", valor);
            this.saldo += valor;
            System.out.println("\n********************************************");
            System.out.println("°          [ DEPÓSITO  BANCÁRIO ]          °");
            System.out.println("Conta: "+numero+"                         Agência: "+agencia);
            System.out.println("DESCRIÇÃO..........................VALOR(R$)");
            System.out.println("DEPÓSITO.............................."+ valorFormatado);
            System.out.println("--------------------------------------------");
            System.out.print("SALDO ANTERIOR.........................."+saldoFormatado);//
            System.out.print("\nSALDO ATUAL...........................");
            System.out.format("%.2f",getSaldo());
            System.out.println("\n********************************************");
        }
    }
    
    public abstract void sacar();
    
    public int getNumero() {
        return this.numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return this.agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        if(this.getNumero()==0 || this.getAgencia()==0){
            return 
                "********************************************\n"+
                "*              CONTA INVÁLIDA              *"+
                "\n********************************************";
        }else{
            String saldoFormatado = String.format("%.2f", saldo);
        return "--------------------------------------------\n"   +
               "°              DADOS BANCÁRIOS             °"     +
               "\n--------------------------------------------\n" +
               "Conta: " + numero + "                  Agência: " + agencia + "\n" + 
               "Cliente: " + cliente + "\n"                 +
               "\nSALDO TOTAL:.......................R$ "+ saldoFormatado +
               "\n--------------------------------------------";
        }
    }
}

/*
1) Conta: 
- Deverá ser abstrata.
	*> Toda a conta possui número, agência, cliente e saldo; 
	*> O número da conta e agência deverá ser > 0 ;
	*> Deverá ter um construtor com (número, agência e cliente);
	*> O atributo saldo deverá ter apenas método get;
	*> Deverá iniciar um saldo 0;
	*> Deverá ter um método (sacar e depositar);
	*> O método sacar deverá ser abstrato;
*/

