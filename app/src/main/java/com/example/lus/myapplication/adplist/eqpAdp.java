package com.example.lus.myapplication.adplist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lus.myapplication.DatabaseHelper;
import com.example.lus.myapplication.R;

import java.sql.SQLException;
import java.util.List;

import com.example.lus.myapplication.model.Team;

/**
 * Created by Luís on 18/02/2016.
 */
public class eqpAdp extends BaseAdapter {

    private Context context;
    private List<Team> lista;
    private DatabaseHelper dbHelper;

    //Construtor
    public eqpAdp (Context ctx , List<Team> equipe, DatabaseHelper dbHelper){
        this.context = ctx;
        this.lista = equipe;
        this.dbHelper = dbHelper;
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
    public View getView(final int position, View view, ViewGroup parent) {
        final Team equipe = lista.get(position);
        //Se view vazia redireciona
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.equipes_layout,null);
        }

        TextView txtnome = (TextView) view.findViewById(R.id.equipe_lista);
        TextView button = (TextView) view.findViewById(R.id.trash);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog(context,position,equipe);

            }
        });

        txtnome.setText(equipe.getNome());


        return view;
    }

    private void confirmDialog(Context context , final int position , final Team equipe){

        final AlertDialog alert = new AlertDialog.Builder(
                new ContextThemeWrapper(context,android.R.style.Theme_Dialog))
                .create();
        alert.setTitle("Atenção!!!");
        alert.setMessage("Deseja realmente apagar " + equipe.getNome() + " ?");
        alert.setCancelable(false);
        alert.setCanceledOnTouchOutside(false);

        alert.setButton(DialogInterface.BUTTON_POSITIVE, "Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            dbHelper.getTimeDao().deleteById(equipe.getId());
                            lista.remove(position);
                            notifyDataSetChanged();
                        } catch (SQLException ignored) {
                        }
                        alert.dismiss();

                    }
                });

        alert.setButton(DialogInterface.BUTTON_NEGATIVE, "Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        alert.dismiss();

                    }
                });

        alert.show();
    }
}
