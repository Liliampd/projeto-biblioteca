package com.mycompany.app;

import java.time.format.DateTimeFormatter;

public class Main {

    private static String fmt(java.time.LocalDateTime d) {
        if (d == null) return "-";
        return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static void main(String[] args) throws InterruptedException {
        // --- Autores com o novo campo "tipo" ---
        Autor autorUsuario = new Autor("Ana Souza", "Brasileira", Autor.TipoAutor.USUARIO);
        Autor autorTradicional = new Autor("Machado de Assis", "Brasileira"); // default = TRADICIONAL

        System.out.println("=== Autores ===");
        System.out.println(autorUsuario);      // toString() do Autor
        System.out.println(autorTradicional);
        System.out.println();

        // --- Livro e Usuário ---
        Livro livro = new Livro("POO na Prática", "Programação", autorUsuario);
        Usuario usuario = new Usuario("Carlos Silva", 25);

        // --- Fluxo de empréstimo ---
        Emprestimo emp = usuario.emprestar(livro);
        if (emp == null) {
            System.out.println("Usuário não está apto ou livro indisponível.");
            return;
        }

        System.out.println("=== Informações do Empréstimo ===");
        System.out.println("Livro: " + livro.getInfo());
        System.out.println("Data de retirada: " + fmt(emp.getDataRetirada()));
        System.out.println("Data prevista de devolução: " + fmt(emp.getDataPrevistaDevolucao()));
        System.out.println("Disponível agora: " + (livro.isDisponivel() ? "Sim" : "Não"));

        // Simula o passar do tempo
        Thread.sleep(1500);

        // --- Devolução ---
        emp.registrarDevolucao();

        System.out.println("\n=== Após Devolução ===");
        System.out.println("Livro: " + livro.getInfo());
        System.out.println("Data de retirada: " + fmt(emp.getDataRetirada()));
        System.out.println("Data prevista de devolução: " + fmt(emp.getDataPrevistaDevolucao()));
        System.out.println("Data devolução: " + fmt(emp.getDataDevolucao()));
        System.out.println("Disponível agora: " + (livro.isDisponivel() ? "Sim" : "Não"));

        // --- Exemplo de uso da classe Artigo ---
        Artigo artigo = new Artigo("Entendendo Compiladores", autorUsuario, "Tecnologia", true);
        System.out.println("\n=== Novo Artigo ===");
        System.out.println(artigo);
    }
}
