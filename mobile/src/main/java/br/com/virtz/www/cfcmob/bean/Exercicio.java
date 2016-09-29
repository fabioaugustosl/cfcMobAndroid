package br.com.virtz.www.cfcmob.bean;


public class Exercicio {

    private String id;
    private String titulo;
    private String idEmpresa;
    private Categoria categoria;


    public Exercicio() {
    }

    public Exercicio(String id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
