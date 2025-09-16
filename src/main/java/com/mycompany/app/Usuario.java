import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private int idade;
    private List<Emprestimo> historicoEmprestimos;

    private static final int MAX_EMPRESTIMOS_ATIVOS = 1; 

    public Usuario(String nome, int idade) {
        super(nome);
        this.idade = idade;
        this.historicoEmprestimos = new ArrayList<>();
    }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public List<Emprestimo> getHistoricoEmprestimos() { return historicoEmprestimos; }
    public void adicionarEmprestimo(Emprestimo e) { historicoEmprestimos.add(e); }

    public int contarEmprestimosAtivos() {
        int ativos = 0;
        for (Emprestimo e : historicoEmprestimos) {
            if (e.getDataDevolucao() == null) ativos++;
        }
        return ativos;
    }

    public boolean verificarApto(Livro livro) {
        if (contarEmprestimosAtivos() >= MAX_EMPRESTIMOS_ATIVOS) return false;
        if (livro == null || !livro.isDisponivel()) return false;
        if (livro.requerMaiorIdade() && idade < 18) return false;
        return true;
    }

    public Emprestimo emprestar(Livro livro) {
        if (!verificarApto(livro)) return null;
        return new Emprestimo(livro, this);
    }

    public void listarHistorico() {
        for (Emprestimo e : historicoEmprestimos) {
            System.out.println("Livro: " + e.getLivro().getTitulo() +
                    " | Retirada: " + e.getDataRetirada() +
                    " | Prevista: " + e.getDataPrevistaDevolucao() +
                    " | Devolução: " + e.getDataDevolucao());
        }
    }
}
