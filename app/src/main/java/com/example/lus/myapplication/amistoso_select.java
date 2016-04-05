package com.example.lus.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lus.myapplication.adplist.AdpListAm;
import com.example.lus.myapplication.adplist.eqpAdp;
import com.example.lus.myapplication.fontawesome.DrawableAwesome;
import com.example.lus.myapplication.model.Team;

import java.sql.SQLException;
import java.util.List;

public class Amistoso_select extends BaseActivity {

    private ListView listaM;
    private List<Team> listaMS;
    private AdpListAm adpM;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amistoso_select);

        listaM = (ListView) findViewById(R.id.lsEquipesAms);

        try {
            listaMS = dbHelper.getTimeDao().queryForAll();
            adpM = new AdpListAm(this, listaMS, dbHelper);
        } catch (SQLException ignored) {}

        listaM.setAdapter(adpM);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // getting icon
        DrawableAwesome.DrawableAwesomeBuilder faBuilder = new DrawableAwesome.DrawableAwesomeBuilder(this, R.string.fa_chevron_left);
        faBuilder.setColor(Color.WHITE);
        faBuilder.setSize(26);
        faBuilder.setFakeBold(false);
        DrawableAwesome fa = faBuilder.build();
        getSupportActionBar().setHomeAsUpIndicator(fa);

        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_amistoso);
        toolbarTitle.setText(R.string.title_activity_amistoso_select);
        toolbarTitle.setTextSize(20);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_amistoso, menu);

        // getting icon
        DrawableAwesome.DrawableAwesomeBuilder faBuilder = new DrawableAwesome.DrawableAwesomeBuilder(this, R.string.fa_chevron_right);
        faBuilder.setColor(Color.WHITE);
        faBuilder.setSize(26);
        faBuilder.setFakeBold(false);
        DrawableAwesome fa = faBuilder.build();

        MenuItem add = menu.findItem(R.id.next_);

        // setting icon
        add.setIcon(fa);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //
        switch (id) {
            case R.id.next_:
                //startActivity(new Intent(this, null));
                return true;

            case android.R.id.home:
                startActivity(new Intent(this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
