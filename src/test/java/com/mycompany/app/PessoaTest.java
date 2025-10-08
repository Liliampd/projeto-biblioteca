package com.mycompany.app;

import org.junit.jupiter.api.Test;

import com.mycompany.app.Pessoa;
import com.mycompany.app.Interface.Pessoavel;

import static org.junit.jupiter.api.Assertions.*;


public class PessoaTest {

    @Test
    void deveCriarPessoaComNome() {
        Pessoavel p = new Pessoa("Ana");
        assertEquals("Ana", p.getNome());
    }
}
