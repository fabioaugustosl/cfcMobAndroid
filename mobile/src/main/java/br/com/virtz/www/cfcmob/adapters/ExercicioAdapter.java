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

public class ExercicioAdapter extends ArrayAdapter<Exercicio> {


    public ExercicioAdapter(Context context, List<Exercicio> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.resource_exercicio_lista, parent, false);
        }

        Exercicio exercicio = getItem(position);

        TextView titulo = (TextView) itemView.findViewById(R.id.tituloExercicio);
        titulo.setText(exercicio.getTitulo());

        return itemView;
    }
}
