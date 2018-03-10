package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;

public class Instrutor implements Serializable {

    private String id;
    private String _id;
    private String nome;
    private String email;
    private String celular;
    private String cfc;


   /* public String get_id() {
        return _id;
    }*/

    public void set_id(String _id) {
        this.id = _id;
        this._id = _id;
    }

    public String getId() {
        if(id != null){
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
