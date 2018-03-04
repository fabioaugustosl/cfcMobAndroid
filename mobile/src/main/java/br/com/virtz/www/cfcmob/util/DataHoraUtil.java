package br.com.virtz.www.cfcmob.util;

import java.util.Calendar;

/**
 * Created by fabio on 03/03/18.
 */

public class DataHoraUtil {

    public static String recuperarPeriodo(){
        Calendar c = Calendar.getInstance();
        Integer horaDoDia = c.get(Calendar.HOUR_OF_DAY);
        if(horaDoDia < 12){
            return "MANHA";
        } else if(horaDoDia >=12 && horaDoDia < 18){
            return "TARDE";
        } else {
            return "NOITE";
        }
    }

}
