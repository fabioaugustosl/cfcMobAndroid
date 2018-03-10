package br.com.virtz.www.cfcmob.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fabio on 01/03/18.
 */

public class Cfc implements Serializable{

    private String id;
    private String _id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String endereco;
    private String cidade;
    private String estado;
    private List<Exercicio> exercicios;
    private List<Falta> faltas;


    public void set_id(String _id) {
        this.id = _id;
        this._id = _id;
    }

    public String getId() {
        if (id != null) {
            return id;
        }
        return _id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }
}
