package br.com.virtz.www.cfcmob.mapper;


import android.content.ContentValues;

import br.com.virtz.www.cfcmob.bean.Exercicio;

public class ExercicioMapper {


    public ContentValues exercicioToContent(Exercicio exercicio){
        ContentValues c = new ContentValues();
        if(exercicio.getId() != null){
            c.put("id", exercicio.getId().toString());
        }
        c.put("titulo", exercicio.getTitulo());
        if(exercicio.getIdEmpresa() != null){
            c.put("id_empresa", exercicio.getIdEmpresa().toString());
        }
        if(exercicio.getCategoria() != null){
            c.put("id_categoria", exercicio.getCategoria().getId().toString());
        }
        return c;
    }

}
