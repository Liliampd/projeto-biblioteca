package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    @Test
    void deveCriarLivroComAutorTituloEGenero() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);

        assertEquals("Java Básico", livro.getTitulo());
        assertEquals("tecnologia", livro.getGenero());
        assertEquals("Jess", livro.getAutor().getNome());
        assertTrue(livro.isDisponivel(), "Novo livro deve iniciar disponível");
    }

    @Test
    void deveAlterarDisponibilidade() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Avançado", "tecnologia", autor);

        livro.setDisponivel(false);
        assertFalse(livro.isDisponivel());

        livro.setDisponivel(true);
        assertTrue(livro.isDisponivel());
    }

    @Test
    void deveRequererMaiorIdadeParaGenerosRestritos() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro l1 = new Livro("Conteúdo 18+", "18+", autor);
        Livro l2 = new Livro("Conteúdo Adulto", "Adulto", autor); // variação de caixa

        assertTrue(l1.requerMaiorIdade());
        assertTrue(l2.requerMaiorIdade());
    }

    @Test
    void getInfoDeveConterTituloGeneroEAutor() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);

        String info = livro.getInfo();
        assertTrue(info.contains("Java Básico"));
        assertTrue(info.contains("tecnologia"));
        assertTrue(info.contains("Jess"));
    }
}
