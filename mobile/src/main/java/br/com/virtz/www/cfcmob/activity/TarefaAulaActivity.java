package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.content.SharedPreferences;
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
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import br.com.virtz.www.cfcmob.util.Util;

import java.util.ArrayList;
import java.util.List;

public class TarefaAulaActivity extends AppCompatActivity {

    private Aluno alunoLogado = null;
    private Cfc cfcLogado = null;
    private Instrutor instrutorLogado = null;
    private Aula aulaAndamento = null;

    private List<String> opcoes;
    private ArrayAdapter<String> adaptador;
    private ListView opcoesTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_aula);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("Qual exercício será executado?");
        //setSupportActionBar(toolbar);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("CFC_SESSAO_GERAL", 0);
        String aluno_sessao = pref.getString("ALUNO_SESSAO",null);

        if(aluno_sessao != null &&  !"".equals(aluno_sessao)){
            alunoLogado = Util.deserialize(aluno_sessao, Aluno.class);
        }

        String cfc_sessao = pref.getString("CFC_SESSAO",null);

        if(cfc_sessao != null &&  !"".equals(cfc_sessao)){
            cfcLogado = Util.deserialize(cfc_sessao, Cfc.class);
        }

        String instrutor_sessao = pref.getString("INSTRUTOR_SESSAO",null);

        if(instrutor_sessao != null &&  !"".equals(instrutor_sessao)){
            instrutorLogado = Util.deserialize(instrutor_sessao, Instrutor.class);
        }

        String aula_sessao = pref.getString("AULA_SESSAO",null);

        if(aula_sessao != null &&  !"".equals(aula_sessao)){
            aulaAndamento = Util.deserialize(aula_sessao, Aula.class);
        }


        final List<Exercicio> exercicios;
        if(cfcLogado != null){
          exercicios = cfcLogado.getExercicios();
        } else {
            exercicios = new ArrayList<Exercicio>();
            exercicios.add(new Exercicio("1", "Controle Embreagem Frontal"));
            exercicios.add(new Exercicio("1", "Controle Embreagem de Ré"));
            exercicios.add(new Exercicio("1", "Ré"));
            exercicios.add(new Exercicio("1", "Baliza"));
            exercicios.add(new Exercicio("1", "Conversão"));
            exercicios.add(new Exercicio("1", "Retorno"));
        }

        opcoesTarefa = (ListView) findViewById(R.id.opcoesTarefa);

        ExercicioAdapter adapter = new ExercicioAdapter(this, exercicios);
        opcoesTarefa.setAdapter(adapter);

        opcoesTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentAvaliacao = new Intent(getBaseContext(), AvaliacaoTarefaActivity.class);
                Exercicio e = exercicios.get(position);
                intentAvaliacao.putExtra("exercicio", Util.serialize(e));
                intentAvaliacao.putExtra("aluno", Util.serialize(alunoLogado));
                intentAvaliacao.putExtra("instrutor", Util.serialize(instrutorLogado));
                intentAvaliacao.putExtra("aula", Util.serialize(aulaAndamento));

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
