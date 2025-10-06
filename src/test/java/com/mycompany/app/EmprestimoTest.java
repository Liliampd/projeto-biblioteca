package com.mycompany.app;

import org.junit.jupiter.api.Test;

import com.mycompany.app.Livro;
import com.mycompany.app.Usuario;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.time.LocalDateTime;

public class EmprestimoTest {

    private Autor autorPadrao() {
        return new Autor("Alan Turing", "Inglês");
    }

    private Usuario usuarioPadrao() {
        return new Usuario("Gabriel", 21);
    }

    @Test
    void deveCriarEmprestimoIndisponibilizandoLivroEPreenchendoCampos() {
        Livro livro = new Livro("Java Basics", "Tecnologia", autorPadrao());
        Usuario usuario = usuarioPadrao();

        Emprestimo e = usuario.emprestar(livro);

        assertNotNull(e);
        assertSame(livro, e.getLivro());
        assertSame(usuario, e.getUsuario());
        assertNotNull(e.getDataRetirada());
        assertNull(e.getDataDevolucao());
        assertFalse(livro.isDisponivel(), "Livro deve ficar indisponível após emprestar");
        assertEquals(1, usuario.contarEmprestimosAtivos());
    }

    @Test
    void getDataPrevistaDevolucaoDeveSerSeteDiasAposRetirada() {
        Livro livro = new Livro("Java Basics", "Tecnologia", autorPadrao());
        Usuario usuario = usuarioPadrao();

        Emprestimo e = usuario.emprestar(livro);

        LocalDateTime prevista = e.getDataPrevistaDevolucao();
        LocalDateTime retirada = e.getDataRetirada();

        assertEquals(retirada.plusDays(Emprestimo.PRAZO_DIAS), prevista);
    }

    @Test
    void registrarDevolucaoDeveLiberarLivroEPreencherData() {
        Livro livro = new Livro("Java Basics", "Tecnologia", autorPadrao());
        Usuario usuario = usuarioPadrao();

        Emprestimo e = usuario.emprestar(livro);
        assertNotNull(e);

        e.registrarDevolucao();

        assertTrue(livro.isDisponivel(), "Após devolução, livro volta a ficar disponível");
        assertNotNull(e.getDataDevolucao(), "Data de devolução deve ser preenchida");
        assertEquals(0, usuario.contarEmprestimosAtivos(), "Após devolução, nenhum empréstimo ativo");
    }

    @Test
    void verificaAtrasoDeveSerFalseQuandoNaoDevolvido() {
        Livro livro = new Livro("Java Basics", "Tecnologia", autorPadrao());
        Usuario usuario = usuarioPadrao();

        Emprestimo e = usuario.emprestar(livro);

        assertFalse(e.verificaAtraso(), "Sem devolução registrada não deve acusar atraso");
    }

    @Test
    void verificaAtrasoDeveSerTrueQuandoDevolvidoDepoisDaDataPrevista() throws Exception {
        Livro livro = new Livro("Java Basics", "Tecnologia", autorPadrao());
        Usuario usuario = usuarioPadrao();

        Emprestimo e = usuario.emprestar(livro);

        // Força a data de retirada para 8 dias atrás para simular atraso
        Field f = Emprestimo.class.getDeclaredField("dataRetirada");
        f.setAccessible(true);
        f.set(e, LocalDateTime.now().minusDays(8));

        e.registrarDevolucao(); // devolve agora (após data prevista)
        assertTrue(e.verificaAtraso(), "Devolvido após a data prevista deve acusar atraso");
    }
}
