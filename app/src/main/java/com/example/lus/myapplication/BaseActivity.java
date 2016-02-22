package com.example.lus.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lus.myapplication.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by Luís on 22/02/2016.
 */
public class BaseActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = (DatabaseHelper) OpenHelperManager.getHelper(this, DatabaseHelper.class);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        OpenHelperManager.releaseHelper();
    }
}
