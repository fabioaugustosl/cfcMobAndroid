package br.com.virtz.www.cfcmob.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.virtz.www.cfcmob.activity.IniciarAulaActivity;
import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.restServices.CfcRestService;
import br.com.virtz.www.cfcmob.util.Util;

/**
 * Created by fabio on 01/03/18.
 */

public class CarregarCfcTask extends AsyncTask<Void, Void, Cfc> {

    private Context mContext = null;
    private String idCfc = null;
    private SharedPreferences preferences = null;


    public CarregarCfcTask(Context context, SharedPreferences pref, String idCfc){
        this.preferences = pref;
        this.idCfc = idCfc;
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Cfc doInBackground(Void... params) {

        Cfc cfc = null;

        //CfcRestService rest = new CfcRestService();
        //cfc = rest.recuperarCfc(idCfc);

        cfc = new Cfc();
        cfc.setNome("ABC Auto Escola");
        cfc.setId("12345");
        cfc.setCidade("BH");

        Exercicio e1 = new Exercicio();
        e1.setNome("Ré");
        e1.setCategoria("A");

        Exercicio e2 = new Exercicio();
        e2.setNome("Controle de embreagem");
        e2.setCategoria("A");

        cfc.setExercicios(new ArrayList<Exercicio>());
        cfc.getExercicios().add(e1);
        cfc.getExercicios().add(e2);


        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("CFC_SESSAO", Util.serialize(cfc));
        editor.commit();

        return cfc;
    }


    @Override
    protected void onPostExecute(Cfc cfc) {
        Intent intentPrincipal = new Intent(mContext, IniciarAulaActivity.class);
        intentPrincipal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intentPrincipal);
    }

}
