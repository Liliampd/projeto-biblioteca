package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Autor extends Pessoa {

    public enum TipoAutor { USUARIO, TRADICIONAL }

    private String nacionalidade;
    private TipoAutor tipo;
    private List<Livro> obrasPublicadas;

    // Construtor "padrão": assume TRADICIONAL
    public Autor(String nome, String nacionalidade) {
        this(nome, nacionalidade, TipoAutor.TRADICIONAL);
    }

    // Construtor completo
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

    /** Retorna uma lista imutável para não expor a coleção interna. */
    public List<Livro> getObrasPublicadas() {
        return Collections.unmodifiableList(obrasPublicadas);
    }

    /** Adiciona um livro à lista de obras publicadas do autor. */
    public void adicionarObra(Livro livro) {
        if (livro != null) {
            obrasPublicadas.add(livro);
        }
    }

    @Override
    public String toString() {
        return "Autor{nome='" + getNome() + "', nacionalidade='" + nacionalidade +
               "', tipo=" + tipo + ", obras=" + obrasPublicadas.size() + "}";
    }
}
