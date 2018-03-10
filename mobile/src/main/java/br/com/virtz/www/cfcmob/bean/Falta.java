package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;

public class Falta implements Serializable {


    private String id;
    private String _id;
    private String nome; //A, B, C, D, E
    private String categoria;



    public Falta() {
    }

    public Falta(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get_id() {
        return _id;
    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}

