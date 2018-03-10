package br.com.virtz.www.cfcmob.restServices;

import java.util.List;

import br.com.virtz.www.cfcmob.bean.Endereco;
import br.com.virtz.www.cfcmob.bean.Instrutor;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;



public interface InstrutorRestServiceInterface {

    public static final String urlInstrutor = "http://35.160.247.116:8001/api/instrutorAutenticacao/v1/";

    @FormUrlEncoded
    @POST("./")
    Call<List<Instrutor>> autenticar(@Field("email") String usuario, @Field("senha") String senha);

}
