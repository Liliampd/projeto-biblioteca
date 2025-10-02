import java.time.LocalDateTime;

public class Emprestimo {
    public static final int PRAZO_DIAS = 7;

    private Livro livro;
    private Usuario usuario;
    private LocalDateTime dataRetirada;
    private LocalDateTime dataDevolucao;

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataRetirada = LocalDateTime.now();
        this.dataDevolucao = null;

        livro.setDisponivel(false);       
        usuario.adicionarEmprestimo(this); 
    }

    public Livro getLivro() { return livro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDateTime getDataRetirada() { return dataRetirada; }
    public LocalDateTime getDataDevolucao() { return dataDevolucao; }

    public LocalDateTime getDataPrevistaDevolucao() {
        return dataRetirada.plusDays(PRAZO_DIAS);
    }

    public void registrarDevolucao() {
        this.dataDevolucao = LocalDateTime.now();
        livro.setDisponivel(true);
    }

    public boolean verificarAtraso() {
        if (dataDevolucao == null) return false;
        return dataDevolucao.isAfter(getDataPrevistaDevolucao());
    }
}
