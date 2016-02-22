package com.example.lus.myapplication.adplist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lus.myapplication.R;

import java.util.List;

import com.example.lus.myapplication.model.Team;

/**
 * Created by Luís on 18/02/2016.
 */
public class eqpAdp extends BaseAdapter {

    private Context context;
    private List<Team> lista;

    //Construtor
    public eqpAdp (Context ctx , List<Team> equipe){
        this.context = ctx;
        this.lista = equipe;
    }

    @Override
    //Retorna a quantidade de  registros
    public int getCount() {
        return lista.size();
    }

    @Override
    //Posição do item
    public Team getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Team equipe = lista.get(position);
        //Se view vazia redireciona
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.equipes_layout,null);
        }

        TextView txtnome = (TextView) view.findViewById(R.id.equipe_lista);
        TextView txtSigla = (TextView) view.findViewById(R.id.equipe_lista_sigla);

        txtnome.setText(equipe.getNome());
        txtSigla.setText(equipe.getSigla());


        return view;
    }
}
