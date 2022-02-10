package projetosJava.ControleDeEstoqueBasico.src;

/* LOCAL ONDE  INVOCAREMOS OS MÉTODOS   */
import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeEstoque {

    Scanner scanner = new Scanner(System.in);
    Scanner entradaString = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList();
    int posicaoAtual = 0;
    int escolha;

    //INICIO MAIN ( );
    public static void main(String[] args) {

        ControleDeEstoque c = new ControleDeEstoque();

        c.inicio();
        c.scanner.nextLine();

    }//FINAL DA MAIN

    //MENU PRINCIPAL
    private void menuPrincipal() {
        System.out.println("*-----------------------------------*");
        System.out.println("|          [ MENU PRINCIPAL ]       |");
        System.out.println("*-----------------------------------*");
        System.out.println("|   [ 1 ] CADASTRO DE PRODUTOS      |");
        System.out.println("|   [ 2 ] MOVIMENTAÇÃO DE PRODUTOS  |");
        System.out.println("|   [ 3 ] REAJUSTE DE PREÇOS        |");
        System.out.println("|   [ 4 ] RELATÓRIO DE PRODUTOS     |");
        System.out.println("|   [ 0 ] FINALIZAR PROGRAMA        |");
        System.out.println("*-----------------------------------*");
        System.out.print("|DIGITE A OPÇÃO: ");

        menuPrincipalOpcao();
    }

    //MENU PRINCIPAL OPÇÃO
    private void menuPrincipalOpcao() {
        int opcao;
        boolean rodando = true;

        do {
            opcao = opcaoMenus();
            switch (opcao) {
                case 1:
                    menuCadastroProdutos();
                    break;
                case 2:
                    menuMovimentacao();
                    break;
                case 3:
                    reajustarPreco();
                    break;
                case 4:
                    relaProd();
                    break;
                case 0:
                    finalizarPrograma();
                    break;
                default:
                    opcaoInvalida();
                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        finalizarPrograma();
                        break;
                    } else {
                        menuPrincipal();
                    }
                    break;
            }
        } while (rodando);
    }

    //MENU CADASTRO DE PRODUTOS
    private void menuCadastroProdutos() {
        System.out.println("*-----------------------------------*");
        System.out.println("|      [ CADASTRO DE PRODUTOS ]     |");
        System.out.println("*-----------------------------------*");
        System.out.println("|   [ 1 ] INCLUIR PRODUTOS          |");
        System.out.println("|   [ 2 ] ALTERAR PRODUTOS          |");
        System.out.println("|   [ 3 ] CONSULTAR PRODUTOS        |");
        System.out.println("|   [ 4 ] EXCLUIR PRODUTOS          |");
        System.out.println("|   [ 0 ] VOLTAR MENU               |");
        System.out.println("*-----------------------------------*");
        System.out.print("|DIGITE A OPÇÃO: ");

        menuCadastroDeProdutosOpcao();
    }

    //MENU CADASTRO PRODUTO OPÇÕES
    private void menuCadastroDeProdutosOpcao() {
        int opcao;

        do {
            opcao = opcaoMenus();
            switch (opcao) {
                case 1: //INCLUIR PRODUTO
                    incluirProdutos();
                    scanner.nextLine();
                    break;
                case 2: //ALTERAR PRODUTO;
                    alterarProdutos();
                    scanner.nextLine();
                    break;
                case 3: //CONSULTAR PRODUTO;
                    consultarProdutos();
                    scanner.nextLine();
                    break;
                case 4: //EXCLUIR PRODUTO;
                    excluirProdutos();
                    break;
                case 0://RETORNAR AO MENU PRINCIPAL
                    menuPrincipal();
                    break;
                default:
                    opcaoInvalida();
                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        finalizarPrograma();
                        break;
                    } else {
                        menuCadastroProdutos();
                        break;
                    }
            }
        } while (opcao != 0);
    }

    // MENU CADASTRO PRODUTO OPÇÕES_INCLUIR PRODUTO
    private void incluirProdutos() {
        Produto p;
        String nome;
        String und;
        double preco;
        float quant;

        System.out.println("*-----------------------------------*");
        System.out.println("        [ INCLUIR PRODUTO ]");
        System.out.print("NOME.........: ");
        nome = scanner.nextLine();
        if (nome.isEmpty()) {
            System.out.println("\t[ NOME INVÁLIDO ]\n");
        } else {
            p = consultar(nome);
            if (p.getNome() != null) {
                System.out.println("\t[ PRODUTO JÁ CADASTRADO ]\n");
                menuCadastroProdutos();
            }
        }
        System.out.print("UNIDADE......: ");
        und = scanner.nextLine();
        if (und.isEmpty()) {
            System.out.println("\t[ UNIDADE INVÁLIDA ]");
            menuCadastroProdutos();
        }

        System.out.print("PREÇO........: ");
        preco = scanner.nextDouble();
        if (preco == 0) {
            System.out.println("\t[ PREÇO INVÁLIDO ]");
            menuCadastroProdutos();
        }

        System.out.print("QUANTIDADE...: ");
        quant = scanner.nextFloat();
        if (!(quant >= 0)) {
            System.out.println("\t[ QUANTIDADE INVÁLIDA ]");
            menuCadastroProdutos();
        }
        System.out.println("*-----------------------------------*");
        scanner.nextLine();

        p = new Produto(nome, und, preco, quant); 
        p.setNome(nome);
        p.setUnd(und);
        p.setPreco(preco);
        p.setQuant(quant);

        desejaIncluir(escolha);
        do {
            escolha = opcaoMenus();
            switch (escolha) {
                case 1: // (SIM) PARA INCLUIR
                    produtos.add(p);  
                    System.out.println("   [ PRODUTO INCLUÍDO NO ESTOQUE ]");
                    System.out.println("");

                case 2: // (NÃO) PARA INCLUIR
                    menuCadastroProdutos();
                    break;
                default:
                    opcaoInvalida();
                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        finalizarPrograma();
                        break;
                    } else {
                        menuCadastroProdutos();
                        break;
                    }
            }
            scanner.nextLine();
        } while (escolha != 2);
    }

    private void alterarProdutos() {
        String nome;
        escolha = 0;

        System.out.println("*-----------------------------------*");
        System.out.println("        [ ALTERAR PRODUTO ]");
        System.out.print("Digite o NOME: ");
        nome = scanner.nextLine();

        Produto retProduto;
        retProduto = new Produto();

        retProduto = consultar(nome);

        if (retProduto.getNome() == null) {
            produtoNaoEncotrado();

            escolha = opcaoMenus();
            if (escolha == 1) {
                incluirProdutos();
                scanner.nextLine();
            } else {
                System.out.println("*-----------------------------------*\n");
                menuCadastroProdutos();
            }

        } else {
            System.out.println("UNIDADE..........: " + retProduto.getUnd());
            System.out.print("NOVA UNIDADE.....: ");
            retProduto.setUnd(scanner.nextLine());

            System.out.println("PREÇO............: " + retProduto.getPreco());
            System.out.print("NOVO PREÇO.......: ");
            retProduto.setPreco(scanner.nextDouble());
            System.out.println("QUANTIDADE.......: " + retProduto.getQuant());
            System.out.print("NOVA QUANTIDADE..: ");
            retProduto.setQuant(scanner.nextFloat());

            desejaAlterar(escolha);
            escolha = opcaoMenus();
            if (escolha == 1) { // (SIM) PARA INCLUIR
                gravarAlteracao(nome, retProduto);

                System.out.println("*-----------------------------------*");
                System.out.println("   [ PRODUTO ALTERADO COM SUCESSO ]");
                System.out.println("*-----------------------------------*");

                menuCadastroProdutos();
            } else {
                menuCadastroProdutos();
            }
        }
    }

    private void consultarProdutos() {
        //scanner.nextLine(); // limpa lixo de memoria !!
        String nome;
        int escolha = 0;

        System.out.println("*-----------------------------------*");
        System.out.println("        [ CONSULTAR PRODUTO ]");
        System.out.print("Digite o NOME: ");
        nome = scanner.nextLine();

        Produto retProd2;
        retProd2 = new Produto();
        retProd2 = consultar(nome);

        if (retProd2.getNome() == null) {
            System.out.println("\n*-----------------------------------*");
            System.out.println("\tPRODUTO NÃO ENCONTRADO !");

            System.out.println("   GOSTARIA DE REALIZAR O CADASTRO ?");
            System.out.print("\t    1- SIM");
            System.out.print("  2- NÃO\n");

            escolha = opcaoMenus();
            if (escolha == 1) {
                incluirProdutos();
                scanner.nextLine();// >>>>>>>>> parei aqui na cópia
            } else if (escolha == 2) {
                System.out.println("*-----------------------------------*\n");
                menuCadastroProdutos();
            }
        } else {
            System.out.println("NOME: " + retProd2.getNome());
            System.out.println("UND: " + retProd2.getUnd());
            System.out.println("PREÇO: " + retProd2.getPreco());
            System.out.println("QTD: " + retProd2.getQuant());
        }
        menuCadastroProdutos(); //tela certa de retorno;
    }

    private String excluirProdutos() {
        String nome;
        escolha = 0;
        boolean rodando = true;
        int exc = 0;

        System.out.println("*-----------------------------------*");
        System.out.println("        [ EXCLUIR PRODUTO ]");
        System.out.print("Digite o NOME: ");
        nome = scanner.nextLine();

        Produto retProd2;
        retProd2 = new Produto();
        retProd2 = consultar(nome);

        if (retProd2.getNome() == null) {
            produtoNaoEncotrado();

            escolha = opcaoMenus();
            if (escolha == 1) {//CASO SIM
                incluirProdutos();
                scanner.nextLine();
            } else if (escolha == 2) {
                System.out.println("*-----------------------------------*\n");
                menuCadastroProdutos();
            }
        } else {//19
            System.out.println("NOME.............: " + retProd2.getNome());
            System.out.println("UNIDADE..........: " + retProd2.getUnd());
            System.out.println("PREÇO............: " + retProd2.getPreco());
            System.out.println("QUANTIDADE.......: " + retProd2.getQuant());
            System.out.println("*-----------------------------------*");

            desejaExcluir(escolha);
            int esc;

            esc = opcaoMenus();
            switch (esc) {
                case 1: // (SIM) PARA EXCLUIR PRODUTO.
                    exc = excluir(nome);
                    System.out.println("*-----------------------------------*");
                    System.out.println("   [ PRODUTO EXCLUÍDO COM SUCESSO ]");
                    System.out.println("*-----------------------------------*");
                    
                    menuCadastroProdutos();
                    
                case 2: // (NÃO) PARA EXCLUIR PRODUTO.
                    menuCadastroProdutos();
                    scanner.nextLine();
                    break;

                default:
                    opcaoInvalida();
                    Scanner entradaString = new Scanner(System.in);

                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        System.out.println("\nFIM DA OPERAÇÃO.");
                        menuCadastroProdutos();
                    } else {
                        excluirProdutos();
                        scanner.nextLine();
                    }
            }
        }
        return null;
    }

    private void menuMovimentacao() {
        System.out.println("*-----------------------------------*");
        System.out.println("|  [ MOVIMENTAÇÃO DE PRODUTOS ]     |");
        System.out.println("*-----------------------------------*");
        System.out.println("|   [ 1 ] ENTRADA DE PRODUTOS       |");
        System.out.println("|   [ 2 ] SAIDA DE PRODUTOS         |");
        System.out.println("|   [ 0 ] VOLTAR MENU               |");
        System.out.println("*-----------------------------------*");
        System.out.print("|DIGITE A OPÇÃO: ");

        menuMovimentacaoOpcoes();
    }

    private void menuMovimentacaoOpcoes() {
        String nome;
        float quant;
        int esc;

        escolha = opcaoMenus();
        scanner.nextLine();
        switch (escolha) {
            case 1://ENTRADA DE PRODUTOS
                System.out.println("*-----------------------------------*");
                System.out.println("        [ ENTRADA DE PRODUTO ]");
                System.out.print("PESQUISA POR NOME: ");
                nome = scanner.nextLine();

                consultar(nome);

                Produto retProd2 = new Produto();
                retProd2 = consultar(nome);

                if (retProd2.getNome() == null) {
                    produtoNaoEncotrado();

                    escolha = opcaoMenus();
                    switch (escolha) {
                        case 1:
                            incluirProdutos();
                            break;
                        case 2:
                            System.out.println("*-----------------------------------*\n");
                            menuMovimentacao();
                            break;
                        default:
                            opcaoInvalida();
                            if (entradaString.nextLine().equalsIgnoreCase("N")) {
                                menuCadastroProdutos();
                                break;
                            } else {
                                menuMovimentacao();
                                scanner.nextLine();
                                break;
                            }
                    }
                } else if (!(retProd2.getNome() == null)) {
                    System.out.println("NOME: " + retProd2.getNome());
                    System.out.println("UNIDADE: " + retProd2.getUnd());
                    System.out.println("PREÇO: " + retProd2.getPreco());
                    System.out.println("QUANTIDADE: " + retProd2.getQuant());

                    System.out.print("\nDIGITE A QUANTIDADE DE ENTRADA: ");
                    quant = scanner.nextFloat();

                    System.out.println("\nCONFIRMAR A MOVIMENTAÇÃO NO ESTOQUE ?");
                    System.out.print("\t    1- SIM");
                    System.out.print("  2- NÃO\n");
                    System.out.print("\t       ");

                    int opcao;
                    opcao = opcaoMenus();
                    switch (opcao) {
                        case 1:
                            retProd2.setQuant(quant + retProd2.getQuant());
                            gravarAlteracao(nome, retProd2);
                            menuMovimentacao();
                            break;
                        case 2:
                            System.out.println("[ MOVIMENTAÇÃO NÃO CONFIRMADA ]");
                            menuMovimentacao();
                            break;
                        default:
                            opcaoInvalida();
                            if (entradaString.nextLine().equalsIgnoreCase("N")) {
                                menuPrincipal();
                                break;
                            } else {
                                menuMovimentacao();
                                scanner.nextLine();
                                break;
                            }
                    }
                }
                break;

            case 2://SAIDA DE PRODUTOS
                System.out.println("*-----------------------------------*");
                System.out.println("        [ SAIDA DE PRODUTO ]");
                System.out.print("PESQUISA POR NOME: ");
                nome = scanner.nextLine();

                consultar(nome);

                retProd2 = consultar(nome);

                if (retProd2.getNome() == null) {
                    produtoNaoEncotrado();

                    esc = opcaoMenus();
                    switch (esc) {
                        case 1:
                            incluirProdutos();
                            break;
                        case 2:
                            System.out.println("*-----------------------------------*\n");
                            menuMovimentacao();
                            break;
                        default:
                            System.out.println("\tOPÇÃO INVÁLIDA !");
                            System.out.println("\tTENTE NOVAMENTE !");
                            menuMovimentacao();
                            break;
                    }
                } else if (!(retProd2.getNome() == null)) {
                    System.out.println("NOME: " + retProd2.getNome());
                    System.out.println("UNIDADE: " + retProd2.getUnd());
                    System.out.println("PREÇO: " + retProd2.getPreco());
                    System.out.println("QUANTIDADE: " + retProd2.getQuant());

                    System.out.print("\nDIGITE A QUANTIDADE DE SAIDA: ");
                    quant = scanner.nextFloat();

                    
                    System.out.println("\nCONFIRMAR A MOVIMENTAÇÃO NO ESTOQUE ?");
                    System.out.print("\t    1- SIM");
                    System.out.print("  2- NÃO\n");
                    System.out.print("\t       ");

                    int opcao;
                    opcao = opcaoMenus();
                    switch (opcao) {
                        case 1:
                            retProd2.setQuant(retProd2.getQuant() - quant);
                            produtos.add(retProd2);
                            menuMovimentacao();
                            break;
                        case 2:
                            System.out.println("[ MOVIMENTAÇÃO NÃO CONFIRMADA ]");
                            menuMovimentacao();
                            break;
                        default:
                            opcaoInvalida();
                            if (entradaString.nextLine().equalsIgnoreCase("N")) {
                                menuPrincipal();
                                break;
                            } else {
                                menuMovimentacao();
                                scanner.nextLine();
                                break;
                            }
                    }
                }
                break;

            case 0://VOLTAR MENU ANTERIOR;
                menuPrincipal();
                break;

            default://OPÇÃO INVALIDA
                opcaoInvalida();
                if (entradaString.nextLine().equalsIgnoreCase("N")) {
                    menuPrincipal();
                    break;
                } else {
                    menuMovimentacao();
                    scanner.nextLine();
                    break;
                }
        }
        scanner.nextLine();
    }

    private void reajustarPreco() {
        String nome;
        double preco, valorPerc;
        int esc;

        scanner.nextLine();

        System.out.println("*-----------------------------------*");
        System.out.println("        [ REAJUSTAR PREÇO ]");
        System.out.print("PESQUISA POR NOME: ");
        nome = scanner.nextLine();

        consultar(nome);

        Produto retProd2 = new Produto();
        retProd2 = consultar(nome);

        if (retProd2.getNome() == null) {
            produtoNaoEncotrado();

            escolha = opcaoMenus();
            switch (escolha) {
                case 1:
                    incluirProdutos();
                    break;
                case 2:
                    System.out.println("*-----------------------------------*\n");
                    menuPrincipal();
                    //reajustarPreco();
                    break;
                default:
                    opcaoInvalida();
                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        menuPrincipal();
                        break;
                    } else {
                        reajustarPreco();
                        scanner.nextLine();
                        break;
                    }
            }
        } else if (!(retProd2.getNome() == null)) {
            System.out.println("NOME: " + retProd2.getNome());
            System.out.println("PREÇO ATUAL: " + String.format("%.2f", retProd2.getPreco()));

            System.out.print("\nQUAL O PERCENTUAL DE REAJUSTE ( % ): ");
            valorPerc = scanner.nextDouble();

            System.out.println("\nDESEJA CONFIRMAR REAJUSTE ?");
            System.out.print("\t    1- SIM");
            System.out.print("  2- NÃO\n");
            System.out.print("\t          ");

            int opcao;
            opcao = opcaoMenus();
            switch (opcao) {
                case 1:
                    retProd2.setPreco(retProd2.getPreco() * ((valorPerc / 100) + 1));
                    gravarAlteracao(nome, retProd2);

                    menuPrincipal();
                    break;
                case 2:
                    System.out.println("[ REAJUSTE NÃO CONFIRMADO ]");
                    menuPrincipal();
                    break;
                default:
                    opcaoInvalida();
                    if (entradaString.nextLine().equalsIgnoreCase("N")) {
                        menuPrincipal();
                        break;
                    } else {
                        reajustarPreco();
                        scanner.nextLine();
                        break;
                    }
            }
        }
    }

    private void relaProd() {

        if (produtos.isEmpty()) {
            System.out.println("\t[ ESTOQUE VAZIO ]");
        } else {
            System.out.println("*-----------------------------------*");
            System.out.println("\t[ LISTA DE PRODUTOS ]");
            System.out.println("*-----------------------------------*");

            System.out.print(String.format("|%7s", "NOME"));
            System.out.print(String.format("|%7s", "UNIDADE"));
            System.out.print(String.format("|%7s", "PREÇO"));
            System.out.print(String.format("|%7s|", "QUANTIDADE"));
            System.out.println("");

            for (Produto p : produtos) {
                System.out.print(String.format("|%7s", p.getNome()));
                System.out.print(String.format("|%7s", p.getUnd()));
                System.out.print(String.format("|%7s", String.format("%.2f", p.getPreco())));
                System.out.println(String.format("|%7s|", String.format("%.2f", p.getQuant())));
            }
        }
        menuPrincipal();
    }

    private void gravarAlteracao(String nome, Produto prodAlterado) {

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                // retProduto.setNome(p.getNome());
                p.setUnd(prodAlterado.getUnd());
                p.setPreco(prodAlterado.getPreco());
                p.setQuant(prodAlterado.getQuant());
            }
        }
    }

    public Produto consultar(String nome) {
        Produto retProduto;
        retProduto = new Produto(); //Criar objeto da Classe

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                retProduto.setNome(p.getNome());
                retProduto.setUnd(p.getUnd());
                retProduto.setPreco(p.getPreco());
                retProduto.setQuant(p.getQuant());
                retProduto.setQdtEstoque(p.getQdtEstoque());
                scanner.nextLine();
            }
        }
        return retProduto;
    }

    public Produto consultarMov(String nome) {
        Produto retProduto;
        retProduto = new Produto(); //Criar objeto da Classe

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                retProduto.setQuant(p.getQuant());
                scanner.nextLine();
            }
        }
        return retProduto;
    }

    private int excluir(String nome) {
        int i = 0;
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(p); // Remoção do produto da ArrayList;
                i = 1;
                break;
            }
        }
        return i;
    }

    private int opcaoMenus() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    //ABERTURA DE TELA
    private void inicio() {
        System.out.println("\nEMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("   SISTEMA DE CONTROLE DE ESTOQUE");

        menuPrincipal();
    }

    private void finalizarPrograma() {
        System.out.println("PROGRAMA ENCERRADO COM SUCESSO !");
        System.exit(0); // forçar parada passando zero como parâmetro;

    }

    private void desejaIncluir(int esc) {
        System.out.println("DESEJA INCLUIR O PRODUTO NO ESTOQUE ? ");
        System.out.print("\t1- SIM");
        System.out.print("\t2- NÃO\n");
        System.out.print("\t       ");
    }

    private void desejaAlterar(int esc) {
        System.out.println("DESEJA ALTERAR O PRODUTO NO ESTOQUE ? ");
        System.out.print("\t1- SIM");
        System.out.print("\t2- NÃO\n");
        System.out.print("\t       ");
    }

    private void desejaExcluir(int esc) {
        System.out.println("DESEJA EXCLUIR O PRODUTO DO ESTOQUE ? ");
        System.out.print("\t1- SIM");
        System.out.print("\t2- NÃO\n");
        System.out.print("\t       ");
    }

    private void opcaoInvalida() {
        System.out.println("*-----------------------------------*");
        System.out.println("\t   OPÇÃO INVÁLIDA !");
        System.out.println("*-----------------------------------*");
        System.out.println("");
        System.out.print("\tDESEJA TENTAR NOVAMENTE ?  ");
        System.out.println("\n\t        [ S/N ]");
        Scanner scanner = new Scanner(System.in);
    }

    private void produtoNaoEncotrado() {
        System.out.println("\n*-----------------------------------*");
        System.out.println("\t[ PRODUTO NÃO ENCONTRADO ]");

        System.out.println("\n   GOSTARIA DE REALIZAR O CADASTRO ?");
        System.out.print("\t    1- SIM");
        System.out.print("  2- NÃO\n");
    }

    private void repetirOperacao() {
        System.out.println("\nREPETIR OPERAÇÃO ? ");
        System.out.print("\t1- SIM");
        System.out.print("\t2- NÃO\n");
    }

    public void setTrataDados() {//CRIAR MÉTODO PARA TRATAR OS DADOS DE ENTRADA;
        Produto p = new Produto();
        String nome;
        String und;
        double preco;
        float quant;
        float qtdEstoque;

    }
}
