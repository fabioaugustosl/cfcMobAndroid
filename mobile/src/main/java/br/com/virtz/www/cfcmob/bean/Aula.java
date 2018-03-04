package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;
import java.util.Date;

public class Aula implements Serializable{

    private String id;
    private Date data;
    private String periodo;
    private String aluno;
    private String cfc;
    private String instrutor;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getCfc() {
        return cfc;
    }

    public void setCfc(String cfc) {
        this.cfc = cfc;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(String instrutor) {
        this.instrutor = instrutor;
    }
}
