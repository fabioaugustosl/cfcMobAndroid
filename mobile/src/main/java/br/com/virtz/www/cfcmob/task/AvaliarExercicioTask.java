package br.com.virtz.www.cfcmob.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.virtz.www.cfcmob.activity.IniciarAulaActivity;
import br.com.virtz.www.cfcmob.activity.TarefaAulaActivity;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.restServices.AvaliarRestService;
import br.com.virtz.www.cfcmob.util.Util;

/**
 * Created by fabio on 03/03/18.
 */

public class AvaliarExercicioTask extends AsyncTask<Void, Void, Boolean> {


    private Context mContext = null;
    private Aluno aluno = null;
    private Exercicio exercicio = null;
    private String idAula = null;
    private String nomeInstrutor = null;
    private Double nota = null;


    public AvaliarExercicioTask(Context context, Aluno aluno, Exercicio exercicio, String idAula, String nomeInstrutor, Double nota){
        this.aluno = aluno;
        this.exercicio = exercicio;
        this.mContext = context;
        this.idAula = idAula;
        this.nomeInstrutor = nomeInstrutor;
        this.nota = nota;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setCfc(aluno.getCfc());
        avaliacao.setAluno(aluno);
        avaliacao.setExercicio(exercicio);
        avaliacao.setLoginAluno(aluno.getLogin());
        avaliacao.setIdAula(this.idAula);
        avaliacao.setNomeAvaliador(this.nomeInstrutor);
        avaliacao.setNota(this.nota);

        AvaliarRestService rest = new AvaliarRestService();
        return rest.avaliar(avaliacao);


        //return avaliacao;
    }


    @Override
    protected void onPostExecute(Boolean avaliacao) {
        if(!avaliacao){
            Toast.makeText(mContext,
                    "Ocorreu um erro ao avaliar exercício.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext,
                    "Exercício avaliado com sucesso!", Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(mContext, TarefaAulaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);

    }


}
