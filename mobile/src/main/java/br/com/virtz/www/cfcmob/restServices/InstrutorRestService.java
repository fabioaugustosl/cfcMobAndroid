package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;
import java.util.List;

import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 04/03/18.
 */

public class InstrutorRestService {

    public Instrutor autenticar(String usuario, String senha){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstrutorRestServiceInterface.urlInstrutor)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InstrutorRestServiceInterface service = retrofit.create(InstrutorRestServiceInterface.class);
        Call<List<Instrutor>> call = service.autenticar(usuario, senha);
        try {
            Response<List<Instrutor>> resp = call.execute();
            List<Instrutor> instrutores = resp.body();
            if(instrutores != null && !instrutores.isEmpty()){
                return instrutores.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
