package projetosJava.EquacaoSegundoGrau.src;

import java.util.Scanner;

public class FormulaBascara {

    public double a, b, c;
    private Scanner scanner;

    public void termosBascara() {
        scanner = new Scanner(System.in);

        System.out.print("Informe o valor de a: ");
        a = scanner.nextDouble();
        System.out.print("Informe o valor de b: ");
        b = scanner.nextDouble();
        System.out.print("Informe o valor de c: ");
        c = scanner.nextDouble();
    }

    public double delta() {
        return (b * b) - (4 * a * c);
    }

    public void raizes(double valordelta) {
        double x1 = (-b + Math.sqrt(valordelta)) / (2 * a);
        double x2 = (-b - Math.sqrt(valordelta)) / (2 * a);

        String x1Format = String.format("%.2f", x1);
        String x2Format = String.format("%.2f", x2);

        System.out.println("Valor da raiz x1 = " + x1Format);
        System.out.println("Valor da raiz x2 = " + x2Format);

        scanner.close();
        
    }
}
