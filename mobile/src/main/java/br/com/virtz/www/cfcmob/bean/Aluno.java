package br.com.virtz.www.cfcmob.bean;


public class Aluno {

    private Integer id;
    private String nome;
    private String email;
    private String celular;
    private Categoria categoria1;
    private Categoria categoria2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Categoria getCategoria1() {
        return categoria1;
    }

    public void setCategoria1(Categoria categoria1) {
        this.categoria1 = categoria1;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Categoria getCategoria2() {
        return categoria2;
    }

    public void setCategoria2(Categoria categoria2) {
        this.categoria2 = categoria2;
    }

}
