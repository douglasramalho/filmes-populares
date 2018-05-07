package br.com.douglasmotta.filmespopulares.data.model;

public class Filme {

    private final String nome;
    private final String caminhoPoster;

    public Filme(String nome, String caminhoPoster) {
        this.nome = nome;
        this.caminhoPoster = caminhoPoster;
    }

    public String getNome() {
        return nome;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
