package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import br.com.virtz.www.cfcmob.task.AvaliarExercicioTask;
import br.com.virtz.www.cfcmob.task.IniciarAulaTask;
import br.com.virtz.www.cfcmob.util.Util;

public class AvaliacaoTarefaActivity extends AppCompatActivity {

    private Exercicio exercicio = null;
    private Aluno aluno = null;
    private Instrutor instrutor = null;
    private Aula aula = null;

    private RatingBar ratingBar = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao_tarefa);

        Intent intent = getIntent();
        String exercicioSerializado = intent.getStringExtra("exercicio");
        String alunoSerializado = intent.getStringExtra("aluno");
        String instrutorSerializado = intent.getStringExtra("instrutor");
        String aulaSerializado = intent.getStringExtra("aula");
        if(exercicioSerializado != null && alunoSerializado != null){
            exercicio = Util.deserialize(exercicioSerializado, Exercicio.class);
            aluno = Util.deserialize(alunoSerializado, Aluno.class);
            instrutor = Util.deserialize(instrutorSerializado, Instrutor.class);
            aula = Util.deserialize(aulaSerializado, Aula.class);

            final TextView txtAvalie = (TextView) findViewById(R.id.txtAvalie);
            txtAvalie.setText("Como foi a execução do exercício '"+exercicio.getNome()+"' pelo aluno?");
        }

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }


    public void avaliarTarefa(View view){

        new AvaliarExercicioTask(getBaseContext(), aluno, exercicio, aula.getId(), instrutor.getNome(), ratingBar.getNumStars()).execute();
        //Aluno aluno, Exercicio exercicio, String idAula, String nomeInstrutor, Double nota
    }
}
