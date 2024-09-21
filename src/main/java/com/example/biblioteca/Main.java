package com.example.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeBiblioteca biblioteca = new GerenciadorDeBiblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Sistema de Biblioteca ---");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Registrar Usuário");
            System.out.println("4. Emprestar Livro");
            System.out.println("5. Devolver Livro");
            System.out.println("6. Listar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ISBN do livro: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Digite o número de cópias disponíveis: ");
                    int copias = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.adicionarLivro(new Livro(titulo, autor, isbn, copias));
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    String id = scanner.nextLine();
                    System.out.print("Digite o contato do usuário: ");
                    String contato = scanner.nextLine();
                    biblioteca.registrarUsuario(new Usuario(nome, id, contato));
                    break;
                case 4:
                    System.out.print("Digite o ISBN do livro: ");
                    String isbnEmprestimo = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    String idUsuario = scanner.nextLine();
                    biblioteca.emprestarLivro(isbnEmprestimo, idUsuario);
                    break;
                case 5:
                    System.out.print("Digite o ISBN do livro a ser devolvido: ");
                    String isbnDevolucao = scanner.nextLine();
                    System.out.print("Digite o ID do usuário: ");
                    String idDevolucao = scanner.nextLine();
                    biblioteca.devolverLivro(isbnDevolucao, idDevolucao);
                    break;
                case 6:
                    biblioteca.listarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
