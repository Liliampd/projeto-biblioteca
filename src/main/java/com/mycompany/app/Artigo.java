package com.mycompany.app;

public class Artigo {
    private String titulo;
    private Autor autor;
    private String genero;
    private boolean publicado;

    public Artigo(String titulo, Autor autor, String genero, boolean publicado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicado = publicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isPublicado() {
        return publicado;
    }

    @Override
    public String toString() {
        return "Artigo{" +
                "titulo='" + titulo + '\'' +
                ", autor=" + autor.getNome() +
                ", genero='" + genero + '\'' +
                ", publicado=" + (publicado ? "Sim" : "Não") +
                '}';
    }
}
