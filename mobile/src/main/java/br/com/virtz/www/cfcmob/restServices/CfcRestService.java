package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;

import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 01/03/18.
 */

public class CfcRestService {

    public Cfc recuperarCfc(String idCfc){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CfcRestServiceInterface.urlCfc)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CfcRestServiceInterface service = retrofit.create(CfcRestServiceInterface.class);
        Call<Cfc> call = service.getCfc(idCfc);
        try {
            Response<Cfc> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
