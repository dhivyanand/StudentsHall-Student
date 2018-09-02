package com.me.system.studentz_hall;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(AppFunctions.doesDatabaseExist(MainActivity.this,"localdb_students_app")){

            AppFunctions.getInto(MainActivity.this);

        }else{

            if(AppFunctions.createLocalDatabase(MainActivity.this)) {
                AppFunctions.getInto(MainActivity.this);
            }

        }



    }
}
