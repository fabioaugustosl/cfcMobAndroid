package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Infracao;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by fabio on 03/03/18.
 */

public interface NotificarInfracaoRestServiceInterface {

    public static final String url = "http://35.160.247.116:8001/api/infracao/v1/";

    @POST("./")
    @Headers("Content-Type: application/json")
    Call<Void> avaliar(@Body Infracao infracao);

}
