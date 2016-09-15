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
import br.com.virtz.www.cfcmob.R;

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

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       // fab.hide();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Qual exercício será executado?");
        //setSupportActionBar(toolbar);

        opcoesTarefa = (ListView) findViewById(R.id.opcoesTarefa);

        opcoes = new ArrayList<String>();
        opcoes.add("Controle Embreagem Frontal");
        opcoes.add("Controle Embreagem de Ré");
        opcoes.add("Ré");
        opcoes.add("Baliza");
        opcoes.add("Conversão");
        opcoes.add("Retorno");


        adaptador = new ArrayAdapter<String>(TarefaAulaActivity.this, android.R.layout.simple_list_item_1, opcoes);
        opcoesTarefa.setAdapter(adaptador);
        opcoesTarefa.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(new Intent(getBaseContext(), AvaliacaoTarefaActivity.class));
                    }
                });
    }


    public void finalizarAula(View view){
        startActivity(new Intent(getBaseContext(), IniciarAulaActivity.class));
    }

}
