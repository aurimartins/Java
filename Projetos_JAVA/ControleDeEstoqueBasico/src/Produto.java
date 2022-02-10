package projetosJava.ControleDeEstoqueBasico.src;

public  class Produto {
    //Atributos
    private String nome, und;
    private double preco ;
    private float quant;
    private float qdtEstoque;

    public Produto(){} //CONSTRUTOR_PRODUTO DEFAULT
    
    //CONSTRUTOR_PRODUTO_PEDINDO PASSAGEM DE PARÂMETROS
    public Produto(String nome, String und, double preco, float quant)
    { this.nome = nome; this.und = und; this.preco = preco; this.quant = quant; }
    
    
    //getts_setts_PRODUTOS
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnd() {
        return und;
    }

    public void setUnd(String und) {
        this.und = und;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public float getQuant() {
        return quant;
    }

    public void setQuant(float quant) {
        this.quant = quant;
    }

    public float getQdtEstoque() {
        return qdtEstoque;
    }

    public void setQdtEstoque(float qdtEstoque) {
        this.qdtEstoque = qdtEstoque;
    }
    

    //toString_PRODUTO
    
    
    @Override
    public String toString() {
        String precoFormatado = String.format("%.2f", preco);
        return "[ Produto ]" + 
               "\nNome: " + nome + 
               "\nUnidade: " + und + 
               "\nPreço R$: " + precoFormatado + 
               "\nQuantidade: " + quant;
    }

    

    
}

