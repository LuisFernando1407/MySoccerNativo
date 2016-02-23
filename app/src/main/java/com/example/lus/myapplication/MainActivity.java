package com.example.lus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Pegando o id dos buttons
        Button btn1 = (Button)findViewById(R.id.btn2);
        Button btn2 = (Button)findViewById(R.id.btn1);
        //Açaõ do click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //chamando a outra tela
                Intent intent = new Intent(getContext(), Crud_Equipe.class);
                startActivity(intent);
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start(v.getContext());
            }

            public void start(Context context) {
                Intent starter = new Intent(context, ListEquipes.class);
                context.startActivity(starter);
            }


        });


    }

    private Context getContext(){

        return this;
    }


}
