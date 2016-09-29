package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.R;

public class AvaliacaoTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_tarefa);

        Intent intent = getIntent();
        String nomeExercicio = intent.getStringExtra("exercicio");
        if(nomeExercicio != null){
            final TextView txtAvalie = (TextView) findViewById(R.id.txtAvalie);
            txtAvalie.setText("Como foi a execução do exercício '"+nomeExercicio+"' pelo aluno?");
        }

    }

    public void avaliarTarefa(View view){

        Toast.makeText(getApplicationContext(),
                "Exercício avaliado com sucesso!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), TarefaAulaActivity.class));

    }
}
