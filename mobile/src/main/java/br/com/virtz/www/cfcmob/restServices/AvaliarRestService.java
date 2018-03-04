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

    public Avaliacao avaliar(Avaliacao avaliacao){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AvaliarRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AvaliarRestServiceInterface service = retrofit.create(AvaliarRestServiceInterface.class);
        Call<Avaliacao> call = service.avaliar(avaliacao);
        try {
            Response<Avaliacao> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
