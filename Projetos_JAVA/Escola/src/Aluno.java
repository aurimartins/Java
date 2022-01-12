package projetosJava.Escola.src;

import java.util.Scanner;

public class Aluno {

    private String nome; // ("João" / "Maria")
    private int idade; //15
    private char sexo; //('M'/'F')
    private String serie; // 1A
    private boolean estuda; //(false/true)

    //encapsulamento feito usando visibilidade private;
    //CONTRUTOR DEFAULT
    public Aluno() {
    }

    //CONTRUTOR PASSANDO PARÂMETROS
    public Aluno(String nome, int idade, char sexo, String serie, boolean estuda) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.serie = serie;
        this.estuda = estuda;
    }

    //GET e SET
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public boolean getEstuda() {
        return estuda;
    }

    public void setEstuda(boolean estuda) {
        if (this.estuda == true && this.sexo == 'M') {
            System.out.println("O aluno " + getNome() + " está matriculado !");
        } else if (this.estuda == true && this.sexo == 'F') {
            System.out.println("A aluna " + getNome() + " está matriculada !");
        } else if (this.estuda == false && this.sexo == 'M') {
            System.out.println("O aluno " + getNome() + " não está matriculado !");
        } else if (this.estuda == false && this.sexo == 'F') {
            System.out.println("A aluna " + getNome() + " não está matriculada !");
        }
        this.estuda = estuda;
    }

    //toString
    @Override
    public String toString() {
        return "DADOS DO ALUNO:"
                + "\nNome: " + nome
                + "\nIdade: " + idade
                + "\nSexo: " + sexo
                + "\nSérie: " + serie
                + "\nEstuda: " + estuda;
    }

    //Menu Apresentação
    public void abertura() {
        System.out.println("-------------------------------------");
        System.out.println("    BEM VINDOS A ESCOLA DO AMANHÃ");
        System.out.println("-------------------------------------");
        System.out.println("");
        
        menuAluno();
    }

    public void menuAluno(){
        System.out.println(" [ 1 ] - CADASTRAR ALUNO");
        System.out.println(" [ 2 ] - HISTÓRICO ");
        System.out.println(" [ 3 ] - BUSCAR ALUNOS");
        System.out.println(" [ 4 ] - EXCLUIR NOTA");
        System.out.println(" [ 0 ] - SAIR DO SISTEMA");
    }
    
    public void opcaoMenuAluno(){
        
        boolean rodando = true;
        
    }

}
