package br.com.douglasmotta.filmespopulares.data.model;

import java.util.List;

public class Filme {

    private final String caminhoPoster;
    private final boolean adulto;
    private final String visaoGeral;
    private final String dataLancamento;
    private final List<Integer> generosIds;
    private final String titulo;

    public Filme(String caminhoPoster, boolean adulto, String visaoGeral, String dataLancamento, List<Integer> generosIds, String titulo) {
        this.caminhoPoster = caminhoPoster;
        this.adulto = adulto;
        this.visaoGeral = visaoGeral;
        this.dataLancamento = dataLancamento;
        this.generosIds = generosIds;
        this.titulo = titulo;
    }

    public String getCaminhoPoster() {
        return caminhoPoster;
    }

    public boolean isAdulto() {
        return adulto;
    }

    public String getVisaoGeral() {
        return visaoGeral;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public List<Integer> getGenerosIds() {
        return generosIds;
    }

    public String getTitulo() {
        return titulo;
    }
}
