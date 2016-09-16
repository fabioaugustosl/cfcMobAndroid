package br.com.virtz.www.cfcmob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.virtz.www.cfcmob.R;

public class ConfiguracaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
    }

    public void salvar(View view){
        Toast.makeText(getApplicationContext(),
                "Configurações salvas com sucesso!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getBaseContext(), IniciarAulaActivity.class));
    }
}
