package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;

public class Instrutor implements Serializable {

    private String id;
    private String nome;
    private String email;
    private String celular;
    private String cfc;

    public String getId() {
        return id;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCfc() {
        return cfc;
    }

    public void setCfc(String cfc) {
        this.cfc = cfc;
    }
}
