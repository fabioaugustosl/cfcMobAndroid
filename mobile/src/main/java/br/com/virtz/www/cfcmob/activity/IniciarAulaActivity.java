package br.com.virtz.www.cfcmob.activity;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import br.com.virtz.www.cfcmob.datepicker.DatePickerFragment;
import br.com.virtz.www.cfcmob.task.CarregarCfcTask;
import br.com.virtz.www.cfcmob.task.IniciarAulaTask;
import br.com.virtz.www.cfcmob.task.ListarAlunosTask;
import br.com.virtz.www.cfcmob.util.Util;

public class IniciarAulaActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private  EditText edtIdContutor = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_aula);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView txtDataAula = (TextView) findViewById(R.id.txtDataAula);
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        txtDataAula.setText("Data da aula: " + sdf.format(dataAtual));

        edtIdContutor = (EditText) findViewById(R.id.edtIdCondutor);
        edtIdContutor.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    iniciarAula(getWindow().getDecorView().getRootView());
                }
                return false;
            }
        });

        verificaSeAulaFoiFinalizada();

        //addItensNoCombo();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void verificaSeAulaFoiFinalizada() {
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        if(message != null){
            Toast toastMessageAulaFinalizada = Toast.makeText(this, message, Toast.LENGTH_LONG);
            toastMessageAulaFinalizada.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio_aula, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.menu_listar_aluno:
                irParaListargemUsuario();
                return true;
            case R.id.menu_cad_aluno:
                irParaCadastrarUsuario();
                return true;
            case R.id.menu_sair:
                sair();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



    public void iniciarAula(View view) {
        // esse trecho era quando aparecia o relogia para início da aula.
        //DialogFragment newFragment = new DatePickerFragment();
        //newFragment.show(getFragmentManager(), "TimePicker");

        String loginAluno = edtIdContutor.getText().toString();

        // TODO - IF login preenchido

        SharedPreferences pref = getApplicationContext().getSharedPreferences("CFC_SESSAO_GERAL", 0);
        String instrutor_sessao = pref.getString("INSTRUTOR_SESSAO",null);
        Instrutor instrutorLogado = null;
        if(instrutor_sessao != null &&  !"".equals(instrutor_sessao)){
            instrutorLogado = Util.deserialize(instrutor_sessao, Instrutor.class);
            new IniciarAulaTask(getBaseContext(), pref, loginAluno, instrutorLogado.getId()).execute();
        }

       // startActivity(new Intent(getBaseContext(), TarefaAulaActivity.class));

    }


    public void irParaConfiguracoes() {
        startActivity(new Intent(getBaseContext(), ConfiguracaoActivity.class));
    }


    public void irParaCadastrarUsuario() {
        startActivity(new Intent(getBaseContext(), NovoAlunoActivity.class));
    }

    public void irParaListargemUsuario() {
        startActivity(new Intent(getBaseContext(), ListarAlunoActivity.class));
    }

    public void sair() {
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
    }


   /* public void addItensNoCombo() {
        // categorias
        categorias.add("Categoria A");
        categorias.add("Categoria B");

        Spinner spinner = (Spinner) findViewById(R.id.comboCategoria);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, categorias);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

    }*/

    public void addListenerOnSpinnerItemSelection() {

    }



}
