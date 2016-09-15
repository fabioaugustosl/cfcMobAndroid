package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.R;

public class NovoAlunoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_novo_aluno);
    }

    public void salvar(View view){

        Toast.makeText(getApplicationContext(),
                "Novo aluno salvo com sucesso!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), IniciarAulaActivity.class));

    }

}
