package br.com.virtz.www.cfcmob.restServices;

import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fabio on 03/03/18.
 */

public interface AlunoRestServiceInterface {

    public static final String url= "http://blablz.com.br/cfcrest/api/aluno/v1/";

    @GET
    Call<Aluno> getAluno(@Query("login") String login);
}
