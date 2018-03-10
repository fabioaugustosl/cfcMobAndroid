package br.com.virtz.www.cfcmob.task;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.activity.TarefaAulaActivity;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.bean.Falta;
import br.com.virtz.www.cfcmob.bean.Infracao;
import br.com.virtz.www.cfcmob.restServices.AvaliarRestService;
import br.com.virtz.www.cfcmob.restServices.NotificarInfracaoRestService;

/**
 * Created by fabio on 03/03/18.
 */

public class NotificarInfracaoTask extends AsyncTask<Void, Void, Boolean> {


    private Context mContext = null;
    private Aluno aluno = null;
    private Falta falta = null;
    private String idAula = null;
    private String nomeInstrutor = null;


    public NotificarInfracaoTask(Context context, Aluno aluno, Falta falta, String idAula, String nomeInstrutora){
        this.aluno = aluno;
        this.falta = falta;
        this.mContext = context;
        this.idAula = idAula;
        this.nomeInstrutor = nomeInstrutor;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        Infracao avaliacao = new Infracao();
        avaliacao.setCfc(aluno.getCfc());
        avaliacao.setAluno(aluno);
        avaliacao.setFalta(falta);
        avaliacao.setLoginAluno(aluno.getLogin());
        avaliacao.setIdAula(this.idAula);
        avaliacao.setNomeAvaliador(this.nomeInstrutor);

        NotificarInfracaoRestService rest = new NotificarInfracaoRestService();
        return rest.notificar(avaliacao);

    }


    @Override
    protected void onPostExecute(Boolean avaliacao) {
        if(!avaliacao){
            Toast.makeText(mContext,
                    "Ocorreu um erro ao notificar infração.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext,
                    "Infração registrada com sucesso!", Toast.LENGTH_SHORT).show();
        }

        Intent i = new Intent(mContext, TarefaAulaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);

    }


}
