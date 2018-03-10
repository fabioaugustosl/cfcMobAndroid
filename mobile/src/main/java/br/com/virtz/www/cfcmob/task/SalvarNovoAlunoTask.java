package br.com.virtz.www.cfcmob.task;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.activity.IniciarAulaActivity;
import br.com.virtz.www.cfcmob.activity.TarefaAulaActivity;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.restServices.AlunoRestService;
import br.com.virtz.www.cfcmob.restServices.AvaliarRestService;

/**
 * Created by fabio on 03/03/18.
 */

public class SalvarNovoAlunoTask extends AsyncTask<Void, Void, Aluno> {

    private ProgressDialog progressDialog = null;
    private Context mContext = null;
    private Aluno aluno = null;


    public SalvarNovoAlunoTask(Context context, Aluno aluno){
        this.aluno = aluno;
        this.mContext = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Aguarde um segundo");
        progressDialog.setMessage("Estamos salvando o cadastro do aluno...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected Aluno doInBackground(Void... params) {

        AlunoRestService rest = new AlunoRestService();
        return rest.salvar(aluno);

    }


    @Override
    protected void onPostExecute(Aluno aluno) {
        progressDialog.dismiss();

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(mContext).create();

        if(aluno != null) {

            alertDialog.setTitle("Aluno criado ");
            // alertDialog.setIcon(R.drawable.ico_sucesso);
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setMessage("O código do aluno é " + aluno.getLogin());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    Intent i = new Intent(mContext, IniciarAulaActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(i);
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        } else {
            alertDialog.setTitle("ERRO!");
            // alertDialog.setIcon(R.drawable.ico_sucesso);
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setMessage("Ocorreu um erro ao salvar o aluno.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {

                    Intent i = new Intent(mContext, IniciarAulaActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(i);
                    dialog.dismiss();
                }
            });
        }

        alertDialog.show();

    }


}
