package projetosJava.EquacaoSegundoGrau.src;

public class EquacaoSegundoGrau {
    public static void main(String[] args) {

            FormulaBascara obj = new FormulaBascara();

            double valordelta = obj.delta();
            System.out.println("DELTA = " + valordelta);
            
            if (valordelta < 0) {
            System.out.print("Não admite solução real");
        } else {
            obj.raizes(valordelta);
        }
        System.out.println();

    }
}

      
