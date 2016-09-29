package br.com.virtz.www.cfcmob.mapper;


import android.content.ContentValues;

import java.text.SimpleDateFormat;

import br.com.virtz.www.cfcmob.bean.Aula;


public class AulaMapper {

    public ContentValues aulaToContent(Aula aula){
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

        ContentValues c = new ContentValues();
        if(aula.getId() != null){
            c.put("id", aula.getId().toString());
        }
        if(aula.getData() != null) {
            c.put("data", sdfData.format(aula.getData()));
        }
        if(aula.getHoraInicio() != null){
            c.put("id", sdfHora.format(aula.getHoraInicio()));
        }
        if(aula.getHoraFim() != null){
            c.put("id", sdfHora.format(aula.getHoraFim()));
        }

        //c.put("instrutor", );
        //c.put("veiculo", );
        //c.put("aluno", );

        return c;
    }

}
