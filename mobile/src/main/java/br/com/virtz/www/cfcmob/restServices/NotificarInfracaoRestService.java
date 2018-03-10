package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;

import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Infracao;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 03/03/18.
 */

public class NotificarInfracaoRestService {

    public boolean notificar(Infracao infracao){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NotificarInfracaoRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NotificarInfracaoRestServiceInterface service = retrofit.create(NotificarInfracaoRestServiceInterface.class);
        Call<Void> call = service.avaliar(infracao);
        try {
            call.execute();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
