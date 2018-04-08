package br.com.douglasmotta.filmespopulares.filme;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import br.com.douglasmotta.filmespopulares.R;

public class FilmeActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_filme);
    }
}
