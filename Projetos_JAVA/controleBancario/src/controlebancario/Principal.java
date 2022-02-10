package controlebancario;
public class Principal {
    public static void main(String[] args) {
        
        //Clientes;
        Cliente c1 = new Cliente ("João", "111.111.111-11");
        Cliente c2 = new Cliente ("Maria", "222.222.222-22");
        
        /*((Conta Corrente))*/
        
        ContaCorrente cc1 = new ContaCorrente(1,10,c1);
        //cc1.criarConta();
        System.out.println(cc1.toString());//Aqui o saldo inicia zerado;
        cc1.depositar(100,c1);//Deposito de R$100,00 na Conta Corrente cc1;
        //System.out.println(cc1.toString());//aqui o saldo mostra o valor depositado;
        //cc1.sacar();//Saque no valor de R$50,00;
        //cc1.sacar();//Saque no valor de R$50,00;
        //System.out.println(cc1.toString());

        /*
        //IMPRIMINDO (cliente,agencia,numero,saldo
        System.out.println(cc1.getCliente());
        System.out.println(cc1.getAgencia());
        System.out.println(cc1.getNumero());
        System.out.println(cc1.getSaldo());
        */
        
        
        
       /*((Conta Poupança))*/
       
        ContaPoupanca cp2 = new ContaPoupanca(2,20,c2);
        cp2.criarConta();
        //System.out.println(cp2.toString());//Aqui o saldo está zerado;
        cp2.depositar(100,c2);//Deposito de R$100,00 na Conta Corrente cc1;
        //System.out.println(cp2.toString());//aqui o saldo mostra o valor depositado;
        //cp2.sacar();//Saque no valor de R$50,00;
        //cp2.sacar();//Saque no valor de R$50,00;
        //System.out.println(cp2.toString());
       
       /*
       //IMPRIMINDO (cliente,agencia,numero,saldo
       System.out.println(cp2.getCliente());
       System.out.println(cp2.getAgencia());
       System.out.println(cp2.getNumero());
       System.out.println(cp2.getSaldo());
       */ 
    }
}

/*
Principal: 
- Deverá ter uma classe Principal que terá o método main;...................(ok)
- Deverá instanciar um objeto conta corrente;...............................(ok) 
- Deverá instanciar um objeto conta poupança;...............................(ok)

- Deverá exibir todas as informações de todos os atributos
    > de conta corrente;....................................................(ok) 
    > de conta poupança;....................................................(ok)
*/

