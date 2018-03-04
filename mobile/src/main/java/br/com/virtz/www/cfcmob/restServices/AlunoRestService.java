package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;

import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 03/03/18.
 */

public class AlunoRestService {

    public Aluno recuperarAlunoPeloLogin(String login){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunoRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AlunoRestServiceInterface service = retrofit.create(AlunoRestServiceInterface.class);
        Call<Aluno> call = service.getAluno(login);
        try {
            Response<Aluno> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
