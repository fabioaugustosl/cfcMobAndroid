package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Avaliacao;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by fabio on 03/03/18.
 */

public interface AvaliarRestServiceInterface {

    public static final String url = "http://35.160.247.116:8001/api/avaliacao/v1/";

    @POST("./")
    @Headers("Content-Type: application/json")
    Call<Avaliacao> avaliar(@Body Avaliacao avaliacao);

}
