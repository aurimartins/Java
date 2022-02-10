package br.unicesumar.aula.controle;

import br.unicesumar.aula.exceptions.DadoConsultadoException;
import br.unicesumar.aula.modelo.Projeto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjetoDAO {

    //Collection que irá armazenar todos os projetos
    @SuppressWarnings("FieldMayBeFinal")
    private static Set<Projeto> projetos = new HashSet<>();

    @Override
    public void adicionar(Projeto projeto) {
        projetos.add(projeto);
    }

    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        Projeto projetoEncontrado = consultarPorNome(nome);
        projetos.remove(projetoEncontrado);
        projetoEncontrado.substituir(projeto);
        projetos.add(projetoEncontrado);

        return projeto;
    }

    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for (Projeto projeto : projetos) {
            if (projeto.getNome().equalsIgnoreCase(nome)) {
                return projeto;
            }
        }
        throw new DadoConsultadoException("Projeto não encontrado com o nome: " + nome);
    }

    @Override
    public List<Projeto> listar() {
        List<Projeto> projetosList = new ArrayList<>();
        projetosList.addAll(projetos);
        return projetosList;
    }

    @Override
    public void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException {
        Projeto projeto = consultarPorNome(nome);
        this.excluir(projeto);
    }

    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException, UnsupportedOperationException {
        if (projetos.contains(projeto)) {
            System.out.println("Dados do Projeto Excluído: \n" + projeto);
            projetos.remove(projeto);
            return;
        }
        throw new DadoConsultadoException("Projeto não encontrado.");
    }

}
