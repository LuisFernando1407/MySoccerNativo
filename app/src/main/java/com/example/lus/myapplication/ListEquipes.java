package com.example.lus.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;
import com.example.lus.myapplication.adplist.eqpAdp;
import com.example.lus.myapplication.fontawesome.DrawableAwesome;
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

        DrawableAwesome.DrawableAwesomeBuilder faBuilder = new DrawableAwesome.DrawableAwesomeBuilder(this, R.string.fa_chevron_left);
        faBuilder.setColor(Color.WHITE);
        faBuilder.setSize(26);
        faBuilder.setFakeBold(false);
        DrawableAwesome fad = faBuilder.build();
        getSupportActionBar().setHomeAsUpIndicator(fad);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.title_activity_list_equipes);
        toolbarTitle.setTextSize(20);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // getting icon
        DrawableAwesome.DrawableAwesomeBuilder faBuilder = new DrawableAwesome.DrawableAwesomeBuilder(this, R.string.fa_plus);
        faBuilder.setColor(Color.WHITE);
        faBuilder.setSize(26);
        faBuilder.setFakeBold(false);
        DrawableAwesome fa = faBuilder.build();

        MenuItem add = menu.findItem(R.id.action_add);

        // setting icon
        add.setIcon(fa);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //
        switch (id) {
            case R.id.action_add:
                startActivity(new Intent(this, Crud_Equipe.class));
                return true;

            case android.R.id.home:
                startActivity(new Intent(this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
