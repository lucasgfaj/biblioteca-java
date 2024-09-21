package com.example.biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int copiasDisponiveis;

    public Livro(String titulo, String autor, String isbn, int copiasDisponiveis) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.copiasDisponiveis = copiasDisponiveis;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiasDisponiveis() {
        return copiasDisponiveis;
    }

    public void setCopiasDisponiveis(int copiasDisponiveis) {
        this.copiasDisponiveis = copiasDisponiveis;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Cópias disponíveis: " + copiasDisponiveis;
    }
}
