package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.app.strategy.EstrategiaPublicacaoArtigo;
import com.mycompany.app.strategy.EstrategiaPublicacaoLivro;

public class AutorStrategyTest {

    @Test
    void devePublicarLivro() {
        Autor autor = new Autor("Ana", "BR");
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro());
        String msg = autor.publicar();
        assertEquals("Publicação de livro realizada", msg);
    }

    @Test
    void devePublicarArtigo() {
        Autor autor = new Autor("Ana", "BR");
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo());
        String msg = autor.publicar();
        assertEquals("Publicação de artigo realizada", msg);
    }

    @Test
    void deveTrocarEstrategiaEmTempoDeExecucao() {
        Autor autor = new Autor("Ana", "BR");
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoLivro());
        assertEquals("Publicação de livro realizada", autor.publicar());
        autor.setEstrategiaPublicacao(new EstrategiaPublicacaoArtigo());
        assertEquals("Publicação de artigo realizada", autor.publicar());
    }

    @Test
    void deveLancarExcecaoQuandoSemEstrategia() {
        Autor autor = new Autor("Ana", "BR");
        assertThrows(IllegalStateException.class, autor::publicar);
    }
}
