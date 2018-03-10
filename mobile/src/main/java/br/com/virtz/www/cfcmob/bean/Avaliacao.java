package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;

public class Avaliacao implements Serializable {

    private String id;
    private String _id;
    private String nomeAvaliador;
    private String idAula;
    private String cfc;
    private String loginAluno;
    private Integer nota;
    private Aluno aluno;
    private Exercicio exercicio;


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

    public String getNomeAvaliador() {
        return nomeAvaliador;
    }

    public void setNomeAvaliador(String nomeAvaliador) {
        this.nomeAvaliador = nomeAvaliador;
    }

    public String getIdAula() {
        return idAula;
    }

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public String getCfc() {
        return cfc;
    }

    public void setCfc(String cfc) {
        this.cfc = cfc;
    }

    public String getLoginAluno() {
        return loginAluno;
    }

    public void setLoginAluno(String loginAluno) {
        this.loginAluno = loginAluno;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }


}
