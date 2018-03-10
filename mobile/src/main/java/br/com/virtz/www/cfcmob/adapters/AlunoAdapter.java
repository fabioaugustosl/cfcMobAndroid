package br.com.virtz.www.cfcmob.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.virtz.www.cfcmob.R;
import br.com.virtz.www.cfcmob.bean.Aluno;
import br.com.virtz.www.cfcmob.bean.Exercicio;

/**
 * Created by fabio on 10/03/18.
 */

public class AlunoAdapter extends ArrayAdapter<Aluno>  {

    public AlunoAdapter(Context context, List<Aluno> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if(itemView == null){
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.resource_aluno_lista, parent, false);
        }
        Aluno aluno = getItem(position);

        TextView nomeAluno = (TextView) itemView.findViewById(R.id.txtNomeAluno);
        nomeAluno.setText(aluno.getNome());

        TextView codigo = (TextView) itemView.findViewById(R.id.txtCodigoAluno);
        codigo.setText(aluno.getLogin());

        return itemView;
    }
}
