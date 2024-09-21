package com.example.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeBiblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public GerenciadorDeBiblioteca() {
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // Gerenciamento de Livros
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro disponível.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    // Gerenciamento de Usuários
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário registrado: " + usuario.getNome());
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    // Gerenciamento de Empréstimos
    public void emprestarLivro(String isbn, String idUsuario) {
        Livro livro = buscarLivroPorIsbn(isbn);
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (livro != null && usuario != null && livro.getCopiasDisponiveis() > 0) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            emprestimos.add(emprestimo);
            livro.setCopiasDisponiveis(livro.getCopiasDisponiveis() - 1);
            System.out.println("Livro emprestado: " + livro.getTitulo() + " para " + usuario.getNome());
        } else {
            System.out.println("Empréstimo não pode ser realizado. Verifique se o livro ou usuário existem, e se há cópias disponíveis.");
        }
    }

    public void devolverLivro(String isbn, String idUsuario) {
        Emprestimo emprestimoRemover = null;

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getIsbn().equals(isbn) && emprestimo.getUsuario().getId().equals(idUsuario)) {
                emprestimoRemover = emprestimo;
                break;
            }
        }

        if (emprestimoRemover != null) {
            emprestimos.remove(emprestimoRemover);
            Livro livro = emprestimoRemover.getLivro();
            livro.setCopiasDisponiveis(livro.getCopiasDisponiveis() + 1);
            System.out.println("Livro devolvido: " + livro.getTitulo());
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    private Livro buscarLivroPorIsbn(String isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
        } else {
            for (Emprestimo emprestimo : emprestimos) {
                System.out.println(emprestimo);
            }
        }
    }
}
