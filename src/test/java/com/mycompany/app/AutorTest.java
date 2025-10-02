package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AutorTest {

    @Test
    void deveCriarAutorComNomeENacionalidade() {
        Autor autor = new Autor("Jess", "Brasileira");

        assertEquals("Jess", autor.getNome());            // herdado de Pessoa
        assertEquals("Brasileira", autor.getNacionalidade());
        assertNotNull(autor.getObrasPublicadas());
        assertTrue(autor.getObrasPublicadas().isEmpty());
    }

    @Test
    void deveAlterarNacionalidade() {
        Autor autor = new Autor("Jess", "Brasileira");
        autor.setNacionalidade("Portuguesa");
        assertEquals("Portuguesa", autor.getNacionalidade());
    }

    @Test
    void deveAdicionarObraNasObrasPublicadas() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);

        autor.adicionarObra(livro);

        List<Livro> obras = autor.getObrasPublicadas();
        assertEquals(1, obras.size());
        assertSame(livro, obras.get(0));
        // informação do livro bate
        assertEquals("Java Básico", obras.get(0).getTitulo());
        assertEquals("tecnologia", obras.get(0).getGenero());
        assertEquals("Jess", obras.get(0).getAutor().getNome());
    }
}
