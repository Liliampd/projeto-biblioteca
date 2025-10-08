package com.mycompany.app;

import com.mycompany.app.Interface.Pessoavel;

public class Pessoa implements Pessoavel {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }
    @Override
    public void setNome(String nome) { this.nome = nome; }
}
