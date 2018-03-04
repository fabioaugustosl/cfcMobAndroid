package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Endereco;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fabio on 26/02/18.
 */

public interface PostomanService {


    @GET("{cep}")
    Call<Endereco> getEndereco(@Path("cep") String cep);

}
