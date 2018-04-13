package br.com.douglasmotta.filmespopulares.ui.listafilmes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.douglasmotta.filmespopulares.R;
import br.com.douglasmotta.filmespopulares.data.model.Filme;

public class ListaFilmesAdapter extends RecyclerView.Adapter<ListaFilmesAdapter.ListaFilmesViewHolder> {

    private List<Filme> filmes;
    private OnFilmeClickListener onFilmeClickListener;

    public ListaFilmesAdapter(List<Filme> filmes, OnFilmeClickListener onFilmeClickListener) {
        this.filmes = filmes;
        this.onFilmeClickListener = onFilmeClickListener;
    }

    @NonNull
    @Override
    public ListaFilmesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_filme, parent, false);

        return new ListaFilmesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaFilmesViewHolder holder, int position) {
        holder.bindFilme(filmes.get(position));
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    static class ListaFilmesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePoster;
        private TextView textTitulo;

        public ListaFilmesViewHolder(View itemView) {
            super(itemView);

            imagePoster = itemView.findViewById(R.id.image_poster);
            textTitulo = itemView.findViewById(R.id.text_titulo);
        }

        public void bindFilme(Filme filme) {
            Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/" + filme.getCaminhoPoster()).into(imagePoster);
            textTitulo.setText(filme.getTitulo());
        }
    }

    public interface OnFilmeClickListener {

        void onClick(Filme filme);
    }
}
