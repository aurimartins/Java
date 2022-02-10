package controlebancario;
public class Cliente {
    private final String nome;
    private final String cpf;
    
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {return this.nome;}
    public String getCpf() {return this.cpf;}

    @Override
    public String toString() {
        return nome + "            CPF:" + cpf ;
    }
}
/*
Cliente:
- Deverá ter um nome e cpf, ambos String;
- Deverá ter um construtor com todos os atributos;
- Deverá ter apenas métodos gets;
*/