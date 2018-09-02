package com.me.system.studentz_hall;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by System on 2/9/18.
 */

public class AppFunctions {

    public static boolean doesDatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }


    public static boolean createLocalDatabase(Context context) {

        try {

            SQLiteDatabase db = context.openOrCreateDatabase("localdb_students_app", Context.MODE_PRIVATE, null);
            db.execSQL("create table hall(exam text , subject text , subject_code text , hall text , date DATETIME DEFAULT CURRENT_TIMESTAMP , session text , attendance text)");
            return true;

        } catch (Exception e) {

            return false;

        }

    }

    public static boolean validateUser(Context context,String uname,String password){
        //validate func goes here after upcoming commits
        return true;
    }


    public static void getInto(Context context){

        SharedPreferences sp = context.getSharedPreferences("MyPref", 0);

        String session = sp.getString("session",null);

        if (TextUtils.equals(session,"in")) {

            String uname = sp.getString("uname",null);
            String pass = sp.getString("pass",null);

            if(validateUser(context,uname,pass))
                context.startActivity(new Intent(context,Index.class));
            else
                context.startActivity(new Intent(context,LoginActivity.class));

        }else{

            context.startActivity(new Intent(context,LoginActivity.class));

        }





    }

}
