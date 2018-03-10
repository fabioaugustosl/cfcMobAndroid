package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.adapters.AlunoAdapter;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.task.ListarAlunosTask;
import br.com.virtz.www.cfcmob.util.Util;

public class ListarAlunoActivity extends AppCompatActivity {


    private AlunoAdapter alunoAdapter;
    private Cfc cfcLogado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_aluno);

        // inicializando a lista de resultado de pesquisa de alunos
        ListView listaView = (ListView) findViewById(R.id.lista_alunos);
        alunoAdapter = new AlunoAdapter(this, new ArrayList<Aluno>());
        listaView.setAdapter(alunoAdapter);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("CFC_SESSAO_GERAL", 0);
        String cfc_sessao = pref.getString("CFC_SESSAO",null);

        if(cfc_sessao != null &&  !"".equals(cfc_sessao)){
            cfcLogado = Util.deserialize(cfc_sessao, Cfc.class);
        }
    }


    public void pesquisar(View view){
        EditText edtNome = (EditText)findViewById(R.id.edtNomeAluno);
        String nome = edtNome.getText().toString();
        if(nome == null || "".equals(nome.trim())){
            Toast.makeText(this,
                    "Favor digitar o nome do aluno!", Toast.LENGTH_SHORT).show();
        } else {
            new ListarAlunosTask(this, alunoAdapter, cfcLogado.getId(), nome).execute();
        }
    }


    public void voltarPrincipal(View view){
        Intent intentPrincipal =  new Intent(this, IniciarAulaActivity.class);
        startActivity(intentPrincipal);
    }
}
