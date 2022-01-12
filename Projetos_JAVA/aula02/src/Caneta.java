package projetosJava.aula02.src;

public class Caneta {
    String modelo;
    public String cor;
    public float ponta;
    int carga;
    boolean tampada;

    public void status() {
        System.out.println("Modelo " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("Ponta " + this.ponta);
        System.out.println("Carga " + this.carga);
        System.out.println("Está Tampada ? " + this.tampada);
    }

    public void rabiscar(){
        if (this.tampada == true){
            System.out.println("ERRO! Caneta tampada.");
        }else {
            System.out.println("Rabiscando !");
        }
    }

    public void tampar(){
        this.tampada = true;
    }
    
    public void destampar() {
        this.tampada = false;
    }
}