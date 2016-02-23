package com.example.lus.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;
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

        lista = (ListView) findViewById(R.id.lsEquipes);

        try {
            listEqp = dbHelper.getTimeDao().queryForAll();
            adp = new eqpAdp(this, listEqp, dbHelper);
        } catch (SQLException ignored) {}

        lista.setAdapter(adp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


}
