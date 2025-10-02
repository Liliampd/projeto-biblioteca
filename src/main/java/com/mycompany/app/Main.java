import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static String fmt(LocalDateTime dt) {
        if (dt == null) return "—";
        return dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static void main(String[] args) {
        // Cadastro enxuto
        Autor autor = new Autor("Ana de Souza", "Brasileira");
        Livro livro = new Livro("POO na Prática", "Programação", autor);
        Usuario usuario = new Usuario("Carlos Silva", 25);

        // Empréstimo
        Emprestimo emp = usuario.emprestar(livro);
        if (emp == null) {
            System.out.println("Usuário não está apto ou livro indisponível.");
            return;
        }

        // ===== Bloco 1: informações iniciais
        System.out.println("O livro: " + livro.getTitulo());
        System.out.println("Autor: " + autor.getNome());
        System.out.println("Gênero: " + livro.getGenero());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println();

        System.out.println("Data de retirada: " + fmt(emp.getDataRetirada()));
        System.out.println("Data prevista de devolução: " + fmt(emp.getDataPrevistaDevolucao()));
        System.out.println("Data de devolução: " + fmt(emp.getDataDevolucao()));
        System.out.println("Disponível agora? " + (livro.isDisponivel() ? "Sim" : "Não"));

        // (apenas para separar visualmente)
        System.out.println("\n----------------------------------------\n");

        // Simula um pequeno tempo e devolve
        try { Thread.sleep(800); } catch (InterruptedException ignored) {}
        emp.registrarDevolucao();

        // ===== Bloco 2: após a devolução
        System.out.println("O livro: " + livro.getTitulo());
        System.out.println("Autor: " + autor.getNome());
        System.out.println("Gênero: " + livro.getGenero());
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println();

        System.out.println("Data de retirada: " + fmt(emp.getDataRetirada()));
        System.out.println("Data prevista de devolução: " + fmt(emp.getDataPrevistaDevolucao()));
        System.out.println("Data de devolução: " + fmt(emp.getDataDevolucao()));
        System.out.println("Disponível agora? " + (livro.isDisponivel() ? "Sim" : "Não"));
    }
}
