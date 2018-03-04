package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Endereco;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;



public interface InstrutorRestService {

    public static final String urlInstrutor = "http://blablz.com.br/cfcrest/api/instrutorAutenticacao/v1/";

    @POST
    @FormUrlEncoded
    Call<Instrutor> autenticar(@Field("usuario") String usuario, @Field("senha") String senha);

}
