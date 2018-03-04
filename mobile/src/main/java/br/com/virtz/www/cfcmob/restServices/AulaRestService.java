package br.com.virtz.www.cfcmob.restServices;

import android.widget.Toast;

import java.io.IOException;
import java.util.Date;

import br.com.virtz.www.cfcmob.activity.IniciarAulaActivity;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 03/03/18.
 */

public class AulaRestService {

    public Aula iniciarAula(String periodo, String aluno, String cfc){
        Aula aula = new Aula();
        aula.setAluno(aluno);
        aula.setCfc(cfc);
        aula.setPeriodo(periodo);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AulaRestServiceInterface.urlAula)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AulaRestServiceInterface service = retrofit.create(AulaRestServiceInterface.class);

        Call<Aula> call = service.iniciarAula(aula);
        try {
            Response<Aula> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
