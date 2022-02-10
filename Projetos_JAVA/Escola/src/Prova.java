package projetosJava.Escola.src;

public class Prova {
    private String materia;
    private String nomeProf;
    private Aluno nomeAluno;
    private double nota;
    private int questaoQtd;
    private boolean status;

    // construtor default
    public Prova() {} 
    //contrutor com parâmetros
    public Prova(String materia, String nomeProf, Aluno nomeAluno, double nota, int questaoQtd, boolean status) {
        this.materia = materia;
        this.nomeProf = nomeProf;
        this.nomeAluno = nomeAluno;
        this.nota = nota;
        this.questaoQtd = questaoQtd;
        this.status = status;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    public Aluno getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(Aluno nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getQuestaoQtd() {
        return questaoQtd;
    }

    public void setQuestaoQtd(int questaoQtd) {
        this.questaoQtd = questaoQtd;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    //toString

    @Override
    public String toString() {
        return "DADOS DA PROVA: " + 
                "Materia: " + materia + 
                "Nome Prof: " + nomeProf + 
                "Nome Aluno: " + nomeAluno + 
                "Nota: " + nota + 
                "Nº Questao: " + questaoQtd + 
                "Status: " + status;
    }
    




    
}
