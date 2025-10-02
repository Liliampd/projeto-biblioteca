
package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    void deveCriarUsuarioComNomeEIdade() {
        Usuario u = new Usuario("Gabriel", 21);
        assertEquals("Gabriel", u.getNome());
        assertEquals(21, u.getIdade());
        assertNotNull(u.getHistoricoEmprestimos());
        assertEquals(0, u.getHistoricoEmprestimos().size());
        assertEquals(0, u.contarEmprestimosAtivos());
    }

    @Test
    void deveEmprestarLivroQuandoApto() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);
        Usuario u = new Usuario("Gabriel", 21);

        Emprestimo e = u.emprestar(livro);

        assertNotNull(e, "Usuário apto deve conseguir emprestar");
        assertFalse(livro.isDisponivel(), "Livro deve ficar indisponível após emprestar");
        assertEquals(1, u.contarEmprestimosAtivos());
        assertSame(u, e.getUsuario());
        assertSame(livro, e.getLivro());
    }

    @Test
    void naoDeveEmprestarSeLivroIndisponivel() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);
        livro.setDisponivel(false); // já emprestado
        Usuario u = new Usuario("Gabriel", 21);

        Emprestimo e = u.emprestar(livro);

        assertNull(e);
        assertEquals(0, u.contarEmprestimosAtivos());
    }

    @Test
    void naoDeveEmprestarSeUltrapassarMaximoAtivos() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro l1 = new Livro("Java Básico", "tecnologia", autor);
        Livro l2 = new Livro("Java Avançado", "tecnologia", autor);
        Usuario u = new Usuario("Gabriel", 21);

        Emprestimo primeiro = u.emprestar(l1);
        Emprestimo segundo = u.emprestar(l2); // MAX_EMPRESTIMOS_ATIVOS = 1

        assertNotNull(primeiro);
        assertNull(segundo, "Não deve emprestar o segundo enquanto houver 1 ativo");
        assertEquals(1, u.contarEmprestimosAtivos());
    }

    @Test
    void naoDeveEmprestarSeMenorDeIdadeParaConteudoRestrito() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro adulto = new Livro("Conteúdo 18+", "18+", autor);
        Usuario menor = new Usuario("Bruno", 16);

        Emprestimo e = menor.emprestar(adulto);

        assertNull(e, "Menor de idade não deve pegar livro 18+");
        assertTrue(adulto.isDisponivel());
        assertEquals(0, menor.contarEmprestimosAtivos());
    }

    @Test
    void registrarDevolucaoDeveLiberarLivroEDiminuirAtivos() {
        Autor autor = new Autor("Jess", "Brasileira");
        Livro livro = new Livro("Java Básico", "tecnologia", autor);
        Usuario u = new Usuario("Gabriel", 21);

        Emprestimo e = u.emprestar(livro);
        assertNotNull(e);
        assertEquals(1, u.contarEmprestimosAtivos());

        e.registrarDevolucao();

        assertTrue(livro.isDisponivel(), "Após devolver, livro volta a ficar disponível");
        assertEquals(0, u.contarEmprestimosAtivos(), "Após devolver, não há empréstimos ativos");
        assertNotNull(e.getDataDevolucao(), "Data de devolução deve ser preenchida");
    }
}
