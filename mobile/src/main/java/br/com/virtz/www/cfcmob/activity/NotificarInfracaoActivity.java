package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.adapters.ExercicioAdapter;
import br.com.virtz.www.cfcmob.adapters.FaltaAdapter;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.bean.Falta;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import br.com.virtz.www.cfcmob.task.AvaliarExercicioTask;
import br.com.virtz.www.cfcmob.task.NotificarInfracaoTask;
import br.com.virtz.www.cfcmob.util.Util;

public class NotificarInfracaoActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_notificar_infracao);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setTitle("Notificar uma infração cometida durante a aula");
       // setSupportActionBar(toolbar);

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

        final List<Falta> faltas = cfcLogado.getFaltas();

        opcoesTarefa = (ListView) findViewById(R.id.opcoesTarefa);

        FaltaAdapter adapter = new FaltaAdapter(this, faltas);
        opcoesTarefa.setAdapter(adapter);

        opcoesTarefa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Falta f = faltas.get(position);

                new NotificarInfracaoTask(getBaseContext(), alunoLogado, f, aulaAndamento.getId(), instrutorLogado.getNome()).execute();
            }
        });
    }


    public void voltar(View view){
        Intent intentInfracao = new Intent(getBaseContext(), NotificarInfracaoActivity.class);
        startActivity(intentInfracao);
    }

}
