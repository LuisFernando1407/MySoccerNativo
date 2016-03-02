package com.example.lus.myapplication.adplist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lus.myapplication.DatabaseHelper;
import com.example.lus.myapplication.R;
import com.example.lus.myapplication.model.Team;

import java.util.List;

/**
 * Created by Luís on 02/03/2016.
 */
public class AdpListAm extends BaseAdapter {

    private Context contextM;
    private List<Team> listaM;
    private DatabaseHelper dbHelperM;

    //Construtor
    public AdpListAm(Context ctx, List<Team> equipe, DatabaseHelper dbHelper){
        this.contextM = ctx;
        this.listaM = equipe;
        this.dbHelperM = dbHelper;
    }
    @Override
    //Retorna a quantidade de  registros
    public int getCount() {
        return listaM.size();
    }

    @Override
    //Posição do item
    public Team getItem(int position) {
        return listaM.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final Team equipe = listaM.get(position);
        //Se view vazia redireciona
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) contextM.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.equipe_layout_ams,null);
        }

        TextView txtnome = (TextView) view.findViewById(R.id.equipe_lista_nome_ams);
        TextView txtsigla = (TextView) view.findViewById(R.id.equipe_lista_sigla_ams);


        txtnome.setText(equipe.getNome());
        txtsigla.setText(equipe.getSigla());


        return view;
    }
}
