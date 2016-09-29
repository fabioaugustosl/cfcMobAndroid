package br.com.virtz.www.cfcmob.mapper;


import android.content.ContentValues;

import br.com.virtz.www.cfcmob.bean.Categoria;

public class CategoriaMapper {

    public ContentValues categoriaToContent(Categoria categoria){
        ContentValues c = new ContentValues();
        if(categoria.getId() != null){
            c.put("id", categoria.getId().toString());
        }
        c.put("nome", categoria.getNome());
        if(categoria.getIdEmpresa() != null){
            c.put("id_empresa", categoria.getIdEmpresa().toString());
        }
        return c;
    }

}
