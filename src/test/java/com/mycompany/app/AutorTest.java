package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutorTest {

    @Test
    @DisplayName("Construtor padrão deve assumir tipo TRADICIONAL")
    void construtorPadraoAssumeTradicional() {
        Autor autor = new Autor("Ana", "Brasileira");
        assertEquals(Autor.TipoAutor.TRADICIONAL, autor.getTipo());
        assertEquals("Brasileira", autor.getNacionalidade());
        assertNotNull(autor.getObrasPublicadas());
        assertTrue(autor.getObrasPublicadas().isEmpty());
    }

    @Test
    @DisplayName("Construtor completo deve aceitar tipo USUARIO")
    void construtorCompletoAceitaUsuario() {
        Autor autor = new Autor("Liliam", "Brasileira", Autor.TipoAutor.USUARIO);
        assertEquals(Autor.TipoAutor.USUARIO, autor.getTipo());
    }

    @Test
    @DisplayName("adicionarObra deve incluir livro e lista exposta deve ser somente leitura")
    void adicionarObraEListaSomenteLeitura() {
        Autor autor = new Autor("Machado", "Brasileira");
        Livro livro = new Livro("Dom Casmurro", "Romance", autor);

        autor.adicionarObra(livro);

        List<Livro> obras = autor.getObrasPublicadas();
        assertEquals(1, obras.size());
        assertEquals("Dom Casmurro", obras.get(0).getTitulo());

        // A lista retornada deve ser imutável (Collections.unmodifiableList)
        assertThrows(UnsupportedOperationException.class, () -> obras.add(livro));
    }
}
