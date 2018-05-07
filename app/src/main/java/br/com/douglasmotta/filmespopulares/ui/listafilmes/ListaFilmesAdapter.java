package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import br.com.douglasmotta.filmespopulares.R;
import br.com.douglasmotta.filmespopulares.data.model.Filme;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;

    public ListaFilmesAdapter() {
        filmes = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bind(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return (filmes != null && filmes.size() > 0) ? filmes.size() : 0;
    }

    public void adicionaFilmes(List<Filme> filmes) {
        final int posicaoInicio = this.filmes.size();

        this.filmes.addAll(filmes);
        notifyItemRangeInserted(posicaoInicio, filmes.size());
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePosterFilme;
        private TextView textTituloFilme;

        public ListaFilmesViewHolder(View itemView) {
            super(itemView);

            imagePosterFilme = itemView.findViewById(R.id.image_poster_filme);
            textTituloFilme = itemView.findViewById(R.id.text_titulo_filme);
        }

        public void bind(Filme filme) {
            Picasso.get().load("https://image.tmdb.org/t/p/w300/" + filme.getCaminhoPoster()).into(imagePosterFilme);
            textTituloFilme.setText(filme.getNome());
        }
    }
}
