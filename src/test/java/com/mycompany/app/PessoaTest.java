package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PessoaTest {

    @Test
    void deveCriarPessoaComNome() {
        Pessoa p = new Pessoa("Ana");
        assertEquals("Ana", p.getNome());
    }
}
