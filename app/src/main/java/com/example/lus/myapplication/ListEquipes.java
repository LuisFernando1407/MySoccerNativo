package com.example.lus.myapplication;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.sql.SQLException;
import java.util.List;

import com.example.lus.myapplication.adplist.eqpAdp;
import com.example.lus.myapplication.model.Team;

public class ListEquipes extends BaseActivity {

    private ListView lista;
    private List<Team> listEqp;
    private eqpAdp adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_equipes);

        try {
            listEqp = dbHelper.getTimeDao().queryForAll();
            adp = new eqpAdp(this, listEqp);
        } catch (SQLException e) {}


        lista = (ListView)findViewById(R.id.lsEquipes);
        lista.setAdapter(adp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
