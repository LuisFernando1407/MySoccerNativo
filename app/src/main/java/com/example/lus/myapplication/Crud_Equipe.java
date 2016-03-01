package com.example.lus.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lus.myapplication.fontawesome.DrawableAwesome;
import com.example.lus.myapplication.model.Team;
import com.example.lus.myapplication.util.Mensagem;

import org.w3c.dom.Comment;

import java.sql.SQLException;

public class Crud_Equipe extends BaseActivity {

    private EditText edtNome , edtSigla ;
    private Button acaoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudequipe);
        //ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        //this->contexto
        edtNome = (EditText) findViewById(R.id.editText);
        edtSigla = (EditText) findViewById(R.id.editText2);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title_crud);
        toolbarTitle.setText(R.string.title_activity_crud_equipes);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //
        switch (id) {
            /*case R.id.action_add:
                startActivity(new Intent(this, Crud_Equipe.class));
                return true;
            */
            case android.R.id.home:
                startActivity(new Intent(this, ListEquipes.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void cadastrar(View view){

        String nome = edtNome.getText().toString();
        String sigla = edtSigla.getText().toString();

        boolean  validacao = true;
        if(nome.equals("")){
            validacao = false;
            edtNome.setError(getString(R.string.validar_nome));

        }
        if(sigla.equals("")){
            validacao = false;
            edtSigla.setError(getString(R.string.validar_senha));
        }

        //True
        if(validacao){

            try {
                Team team = new Team();
                team.setSigla(sigla);
                team.setNome(nome);
                dbHelper.getTimeDao().create(team);

                Mensagem.Msg(this, getString(R.string.cadastro_sucs));
                startActivity(new Intent(this, ListEquipes.class));
                finish();
            } catch(Exception e) {

                Mensagem.Msg(this, getString(R.string.error_cad));
            }
        }
    }





}
