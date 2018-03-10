package br.com.virtz.www.cfcmob.bean;


import java.io.Serializable;

public class Infracao implements Serializable {

    private String id;
    private String _id;
    private String nomeAvaliador;
    private String idAula;
    private String cfc;
    private String loginAluno;
    private Aluno aluno;
    private Falta falta;


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

    public String get_id() {
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public Falta getFalta() {
        return falta;
    }

    public void setFalta(Falta falta) {
        this.falta = falta;
    }
}
