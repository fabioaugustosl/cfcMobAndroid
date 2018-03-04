package br.com.virtz.www.cfcmob.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.util.ArrayList;

import br.com.virtz.www.cfcmob.activity.IniciarAulaActivity;
import br.com.virtz.www.cfcmob.activity.TarefaAulaActivity;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.restServices.AlunoRestService;
import br.com.virtz.www.cfcmob.restServices.AulaRestService;
import br.com.virtz.www.cfcmob.util.DataHoraUtil;
import br.com.virtz.www.cfcmob.util.Util;

/**
 * Recupera o aluno no serviço rest. Caso o login/matricula do aluno esteja
 * correta eh chamado o serviço de inicio de aula e
 * o app direciona para a tela de avaliação de exercicios
 */
public class IniciarAulaTask extends AsyncTask<Void, Void, Aluno> {

    private Context mContext = null;
    private String loginAluno = null;
    private SharedPreferences preferences = null;
    private String instrutor = null;


    public IniciarAulaTask(Context context, SharedPreferences pref, String loginAluno, String instrutor){
        this.preferences = pref;
        this.loginAluno = loginAluno;
        this.mContext = context;
        this.instrutor = instrutor;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Aluno doInBackground(Void... params) {

        Aluno aluno = null;

        //AlunoRestService rest = new AlunoRestService();
        //aluno = rest.recuperarAlunoPeloLogin(loginAluno);



        aluno = new Aluno();
        aluno.setNome("Fabio Lopes");
        aluno.setId("12345");

        Aula aula = null;

        // if aluno != null
        //AulaRestService restAula = new AulaRestService();
        //aula = restAula.iniciarAula(DataHoraUtil.recuperarPeriodo(), loginAluno, aluno.getCfc());
        aula = new Aula();
        aula.setPeriodo("MANHA");
        aula.setCfc("1234567");
        aula.setInstrutor(instrutor);
        aula.setAluno(loginAluno);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("ALUNO_SESSAO", Util.serialize(aluno));
        editor.putString("AULA_SESSAO", Util.serialize(aula));
        editor.commit();

        return aluno;
    }


    @Override
    protected void onPostExecute(Aluno aluno) {
        // TODO - if aluno não existe exibir mensagem

        // ELSE esse codigo abaixo

        Intent intentPrincipal = new Intent(mContext, TarefaAulaActivity.class);
        intentPrincipal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intentPrincipal);
    }

}
