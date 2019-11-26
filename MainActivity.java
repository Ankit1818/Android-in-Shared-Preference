package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences sharedPreferences=getSharedPreferences("user_session",MODE_PRIVATE);

        if(sharedPreferences.getBoolean("session",false) &&
                !sharedPreferences.getString("email","").isEmpty()){

            startActivity(new Intent(MainActivity.this,HomeActivity.class));
            finish();
        }

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ed,itText email=findViewById(R.id.email);
                EditText pass=findViewById(R.id.password);

                String email1=email.getText().toString();
                String pass1=pass.getText().toString();


                if(email1.length()==0)
                {
                    Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                }
                else if(pass1.length()==0)
                {
                    Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                }

                else if(!email1.equals("tops")&&!pass1.equals("tops"))
                {
                    Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    sharedPreferences.edit().putString("email",email.getText().toString()).commit();
                    sharedPreferences.edit().putBoolean("session",true).commit();

                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                }


            }
        });

    }
}