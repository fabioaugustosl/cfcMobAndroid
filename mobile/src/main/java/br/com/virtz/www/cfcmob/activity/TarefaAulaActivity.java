package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.adapters.ExercicioAdapter;
import br.com.virtz.www.cfcmob.bean.Exercicio;

import java.util.ArrayList;
import java.util.List;

public class TarefaAulaActivity extends AppCompatActivity {


    List<String> opcoes;
    ArrayAdapter<String> adaptador;
    ListView opcoesTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_aula);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Qual exercício será executado?");
        //setSupportActionBar(toolbar);


        final List<Exercicio> exercicios = new ArrayList<Exercicio>();
        exercicios.add(new Exercicio("1", "Controle Embreagem Frontal"));
        exercicios.add(new Exercicio("1", "Controle Embreagem de Ré"));
        exercicios.add(new Exercicio("1", "Ré"));
        exercicios.add(new Exercicio("1", "Baliza"));
        exercicios.add(new Exercicio("1", "Conversão"));
        exercicios.add(new Exercicio("1", "Retorno"));

        opcoesTarefa = (ListView) findViewById(R.id.opcoesTarefa);

        ExercicioAdapter adapter = new ExercicioAdapter(this, exercicios);
        opcoesTarefa.setAdapter(adapter);

        opcoesTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentAvaliacao = new Intent(getBaseContext(), AvaliacaoTarefaActivity.class);
                Exercicio e = exercicios.get(position);
                intentAvaliacao.putExtra("exercicio", e.getTitulo());

                startActivity(intentAvaliacao);
            }
        });

    }


    public void finalizarAula(View view){
        Intent intentAula = new Intent(getBaseContext(), IniciarAulaActivity.class);
        intentAula.putExtra("message", "Aula finalizada com sucesso!");

        startActivity(intentAula);
    }

}
