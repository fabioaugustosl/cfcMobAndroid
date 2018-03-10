package br.com.virtz.www.cfcmob.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.bean.Exercicio;
import br.com.virtz.www.cfcmob.bean.Falta;

public class FaltaAdapter extends ArrayAdapter<Falta> {


    public FaltaAdapter(Context context, List<Falta> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.resource_falta_lista, parent, false);
        }

        Falta falta = getItem(position);

        TextView titulo = (TextView) itemView.findViewById(R.id.tituloFalta);
        titulo.setText(falta.getNome());

        return itemView;
    }
}
