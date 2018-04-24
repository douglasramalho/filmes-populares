package br.com.douglasmotta.filmespopulares.data.model;

public class Filme {

    private final String nome;

    public Filme(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
