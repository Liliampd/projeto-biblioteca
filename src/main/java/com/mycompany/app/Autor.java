package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.mycompany.app.Interface.PublicavelInterface;

public class Autor extends Pessoa {

    public enum TipoAutor { USUARIO, TRADICIONAL }

    private String nacionalidade;
    private TipoAutor tipo;
    private List<Livro> obrasPublicadas;
    private PublicavelInterface estrategiaPublicacao;

    public Autor(String nome, String nacionalidade) {
        this(nome, nacionalidade, TipoAutor.TRADICIONAL);
    }

    public Autor(String nome, String nacionalidade, TipoAutor tipo) {
        super(nome);
        this.nacionalidade = nacionalidade;
        this.tipo = tipo;
        this.obrasPublicadas = new ArrayList<>();
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public TipoAutor getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutor tipo) {
        this.tipo = tipo;
    }

    public List<Livro> getObrasPublicadas() {
        return Collections.unmodifiableList(obrasPublicadas);
    }

    public void adicionarObra(Livro livro) {
        if (livro != null) {
            obrasPublicadas.add(livro);
        }
    }

    public void setEstrategiaPublicacao(PublicavelInterface estrategia) {
        this.estrategiaPublicacao = estrategia;
    }

    public String publicar() {
        if (estrategiaPublicacao == null) {
            throw new IllegalStateException("Estratégia de publicação não definida.");
        }
        return estrategiaPublicacao.publicar();
    }

    @Override
    public String toString() {
        return "Autor{nome='" + getNome() + "', nacionalidade='" + nacionalidade +
               "', tipo=" + tipo + ", obras=" + obrasPublicadas.size() + "}";
    }
}
