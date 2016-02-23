package com.example.lus.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.lus.myapplication.model.Team;
import com.example.lus.myapplication.util.Mensagem;

import org.w3c.dom.Comment;

import java.sql.SQLException;

public class Crud_Equipe extends BaseActivity {

    private EditText edtNome , edtSigla ;


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
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } catch(Exception e) {

                Mensagem.Msg(this, getString(R.string.error_cad));
            }
        }
    }




}
