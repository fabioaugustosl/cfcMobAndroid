package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.task.SalvarNovoAlunoTask;
import br.com.virtz.www.cfcmob.util.Util;

public class NovoAlunoActivity extends AppCompatActivity {

    private List<String> categorias;
    private  Spinner spinner = null;
    private Cfc cfcLogado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_novo_aluno);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("CFC_SESSAO_GERAL", 0);

        String cfc_sessao = pref.getString("CFC_SESSAO",null);

        if(cfc_sessao != null &&  !"".equals(cfc_sessao)){
            cfcLogado = Util.deserialize(cfc_sessao, Cfc.class);
        }

        addItensNoCombo();
    }


     public void addItensNoCombo() {
        // categorias
        categorias.add("Categoria A");
        categorias.add("Categoria B");

        spinner = (Spinner) findViewById(R.id.comboCategoria);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categorias);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }

    public void salvar(View view){
        String categoria = spinner.getSelectedItem().toString();
        String nome = ((EditText)findViewById(R.id.edtNomeAluno)).getText().toString();
        String email = ((EditText)findViewById(R.id.edtEmailAluno)).getText().toString();
        String celular = ((EditText)findViewById(R.id.edtCelularAluno)).getText().toString();

        if(nome == null || "".equals(nome.trim())){
            Toast.makeText(getApplicationContext(),
                    "O nome do aluno é obrigatório!", Toast.LENGTH_SHORT).show();
            return;
        }

        Aluno aluno = new Aluno();
        aluno.setCategoria(categoria);
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCelular(celular);
        aluno.setCfc(cfcLogado.getId());

        new SalvarNovoAlunoTask(this, aluno);

    }



}
