package com.example.asus.sciencequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username_input;
    private TextView username_view;

    Button btn_submit;

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_input = (EditText)findViewById(R.id.username_input);
        username_view = (TextView) findViewById(R.id.username_view);

        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = username_input.getText().toString();
                if (username.equals("")){
                    Toast.makeText(MainActivity.this,"Please enter your username", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,"Welcome " + username, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, ScienceActivity.class);
                    intent.putExtra("USERNAME_INPUT",username);
                    startActivity(intent);
                }


            }
        });

    }
}
