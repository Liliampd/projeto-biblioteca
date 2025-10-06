package com.mycompany.app;

import java.time.format.DateTimeFormatter;

import com.mycompany.app.Livro;
import com.mycompany.app.Usuario;

public class Main {

    private static String fmt(java.time.LocalDateTime d) {
        if (d == null) return "-";
        return d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static void main(String[] args) throws InterruptedException {
        Autor autor = new Autor("Ana Souza", "Brasileira");
        Livro livro = new Livro("POO na Prática", "Programação", autor);
        Usuario usuario = new Usuario("Carlos Silva", 25);

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

        Thread.sleep(2000);
        emp.registrarDevolucao();

        System.out.println("\n=== Após Devolução ===");
        System.out.println("Livro: " + livro.getInfo());
        System.out.println("Data de retirada: " + fmt(emp.getDataRetirada()));
        System.out.println("Data prevista de devolução: " + fmt(emp.getDataPrevistaDevolucao()));
        System.out.println("Data devolução: " + fmt(emp.getDataDevolucao()));
        System.out.println("Disponível agora: " + (livro.isDisponivel() ? "Sim" : "Não"));
    }
}
