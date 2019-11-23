package com.codewithharry.sharedharry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = editText.getText().toString();

                SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("str1", msg);
                editor.putString("str2", "This is value 2 added by harry");
                editor.putString("str3", "This is value 3 added by harry");
                editor.apply();

                textView.setText(msg);

            }
        });

        // Get the value of shared preference back
        SharedPreferences getShared = getSharedPreferences("demo", MODE_PRIVATE);
        String value1 = getShared.getString("str1","Save a note and it will show up here");
        String value2 = getShared.getString("str2","Save a note and it will show up here");
        String value3 = getShared.getString("str3","Save a note and it will show up here");
        textView.setText(value1 + value2 + value3);


    }
}

