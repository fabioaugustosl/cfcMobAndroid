package br.com.virtz.www.cfcmob.mapper;


import android.content.ContentValues;

import br.com.virtz.www.cfcmob.bean.Avaliacao;


public class AvaliacaoMapper {

    public ContentValues avaliacaoToContent(Avaliacao avaliacao){
        ContentValues c = new ContentValues();
        if(avaliacao.getId() != null){
            c.put("id", avaliacao.getId().toString());
        }
        c.put("pontos", avaliacao.getPontos().toString());
        if(avaliacao.getAula() != null){
            c.put("id_aula", avaliacao.getAula().getId().toString());
        }
        return c;
    }

}
