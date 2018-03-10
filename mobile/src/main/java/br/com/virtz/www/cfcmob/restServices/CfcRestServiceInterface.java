package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Cfc;
import br.com.virtz.www.cfcmob.bean.Endereco;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fabio on 01/03/18.
 */

public interface CfcRestServiceInterface {

    public static final String urlCfc= "http://35.160.247.116:8001/api/cfc/v1/";

    @GET("{idCfc}")
    Call<Cfc> getCfc(@Path("idCfc") String idCfc);

}
