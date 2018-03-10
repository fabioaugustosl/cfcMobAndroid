package br.com.virtz.www.cfcmob.restServices;

import java.io.IOException;
import java.util.List;

import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Aula;
import br.com.virtz.www.cfcmob.bean.Cfc;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fabio on 03/03/18.
 */

public class AlunoRestService {

    public Aluno recuperarAlunoPeloLogin(String login){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunoRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AlunoRestServiceInterface service = retrofit.create(AlunoRestServiceInterface.class);
        Call<List<Aluno>> call = service.getAluno(login);
        try {
            Response<List<Aluno>> resp = call.execute();
            List<Aluno> alunos = resp.body();
            if(alunos != null && !alunos.isEmpty()) {
                return alunos.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Aluno> pesquisarAlunos(String cfc, String nome){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunoRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AlunoRestServiceInterface service = retrofit.create(AlunoRestServiceInterface.class);
        Call<List<Aluno>> call = service.pesquisar(cfc, nome);
        try {
            Response<List<Aluno>> resp = call.execute();
            List<Aluno> alunos = resp.body();
            return alunos;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public Aluno salvar(String cfc, String nome, String categoria, String email, String celular){
        Aluno aluno = new Aluno();
        aluno.setCfc(cfc);
        aluno.setNome(nome);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setCategoria(categoria);

        return salvar(aluno);
    }

    public Aluno salvar(Aluno aluno){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AlunoRestServiceInterface.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AlunoRestServiceInterface service = retrofit.create(AlunoRestServiceInterface.class);

        Call<Aluno> call = service.salvar(aluno);
        try {
            Response<Aluno> resp = call.execute();
            return resp.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
