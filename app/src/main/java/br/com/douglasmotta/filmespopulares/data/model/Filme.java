package br.com.douglasmotta.filmespopulares.data.model;

import java.io.Serializable;

public class Filme implements Serializable {

    private final String titulo;
    private final String caminhoPoster;

    public Filme(String titulo, String caminhoPoster) {
        this.titulo = titulo;
        this.caminhoPoster = caminhoPoster;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }
}
