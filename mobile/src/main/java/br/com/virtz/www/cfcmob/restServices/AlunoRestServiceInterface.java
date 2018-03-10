package br.com.virtz.www.cfcmob.restServices;

import java.util.List;

import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fabio on 03/03/18.
 */

public interface AlunoRestServiceInterface {

    public static final String url= "http://35.160.247.116:8001/api/aluno/v1/";

    @GET("./")
    Call<List<Aluno>> getAluno(@Query("login") String login);

    @GET("./")
    Call<List<Aluno>> pesquisar(@Query("cfc") String cfc, @Query("nome") String nome);

    @POST("./")
    @Headers("Content-Type: application/json")
    Call<Aluno> salvar(@Body Aluno aluno);
}
