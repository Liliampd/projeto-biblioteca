package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArtigoTest {

    @Test
    void deveCriarArtigoComDadosCorretos() {
        Autor autor = new Autor("Liliam", "Brasileira", Autor.TipoAutor.USUARIO);
        Artigo artigo = new Artigo("Entendendo Compiladores", autor, "Tecnologia", true);

        assertEquals("Entendendo Compiladores", artigo.getTitulo());
        assertEquals(autor, artigo.getAutor());
        assertEquals("Tecnologia", artigo.getGenero());
        assertTrue(artigo.isPublicado());
    }

    @Test
    void toStringDeveConterInformacoesPrincipais() {
        Autor autor = new Autor("Ana Souza", "Brasileira", Autor.TipoAutor.USUARIO);
        Artigo artigo = new Artigo("POO Avançada", autor, "Programação", false);

        String texto = artigo.toString();
        assertTrue(texto.contains("POO Avançada"));
        assertTrue(texto.contains("Ana Souza"));
        assertTrue(texto.contains("Programação"));
    }
}
