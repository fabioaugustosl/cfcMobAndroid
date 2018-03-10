package br.com.virtz.www.cfcmob.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.restServices.AlunoRestService;
import br.com.virtz.www.cfcmob.restServices.AulaRestService;
import br.com.virtz.www.cfcmob.util.DataHoraUtil;

/**
 * Created by fabio on 10/03/18.
 */

public class ListarAlunosTask  extends AsyncTask<String, Void, List<Aluno>> {

    private Context mContext;
    private ArrayAdapter adapter = null;
    private ProgressDialog progressDialog = null;
    private String idCfc = null;
    private String nome = null;


    public ListarAlunosTask(Context context, ArrayAdapter adapter, String idCfc, String nomeAluno) {
        mContext = context;
        this.adapter = adapter;
        this.idCfc = idCfc;
        this.nome = nomeAluno;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Aguarde um segundo");
        progressDialog.setMessage("Estamos pesquisando os alunos...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected List<Aluno> doInBackground(String... params) {
        List<Aluno> alunos = null;

        AlunoRestService rest = new AlunoRestService();
        alunos = rest.pesquisarAlunos(idCfc, nome);


        return alunos;
    }


    @Override
    protected void onPostExecute(List<Aluno> alunos) {
        adapter.clear();

        adapter.addAll(alunos);
        adapter.notifyDataSetChanged();

        progressDialog.dismiss();
    }

}
