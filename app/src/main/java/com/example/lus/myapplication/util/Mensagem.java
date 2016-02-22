package com.example.lus.myapplication.util;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Luís on 18/02/2016.
 */
public class Mensagem {

    public static void Msg(Activity activity , String msg){

        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }
}
