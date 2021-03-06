package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;

import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 03/03/18.
 */

public class AvaliarRestService {

    public boolean avaliar(Avaliacao avaliacao){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AvaliarRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AvaliarRestServiceInterface service = retrofit.create(AvaliarRestServiceInterface.class);
        Call<Void> call = service.avaliar(avaliacao);
        try {
            call.execute();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
