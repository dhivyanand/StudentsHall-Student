package com.me.system.studentz_hall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    String reg , pass;
    EditText _reg , _pass;
    Button _in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _reg = (EditText)findViewById(R.id.reg);
        _pass = (EditText)findViewById(R.id.pass);
        _in = (Button)findViewById(R.id.in);

        _in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reg = _reg.getText().toString();
                pass = _pass.getText().toString();

                if(!(reg.isEmpty() && pass.isEmpty()))
                    if(AppFunctions.validateLogin(LoginActivity.this,reg,pass)) {
                        AppFunctions.createPreference(LoginActivity.this, reg, pass);
                        startActivity(new Intent(LoginActivity.this,Index.class));
                    }

            }
        });


    }
}
