public class Livro {
    private String titulo;
    private String genero;
    private Autor autor;
    private boolean disponivel;

    public Livro(String titulo, String genero, Autor autor) {
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.disponivel = true; 
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public Autor getAutor() { return autor; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public boolean requerMaiorIdade() {
        String g = genero == null ? "" : genero.toLowerCase();
        return g.contains("18+") || g.contains("adulto");
    }

    public String getInfo() {
        return "Título: " + titulo + ", Gênero: " + genero + ", Autor: " + autor.getNome();
    }
}
