package com.example.android.loginappilication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView textview;
    TextView textview2;
EditText password,username;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview=(TextView)findViewById(R.id.textview1);
        textview2=(TextView)findViewById(R.id.textview2);
        password=(EditText)findViewById(R.id.Edittext2);
        username=(EditText)findViewById(R.id.Edittext1);
        button=(Button)findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String user=;
               // String pass= ;
                if(validate(username.getText().toString(),password.getText().toString()))
                {
                    Intent i= new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                }
                else
                {
                    textview2.setText("You entered  wrong  credentials !");
                    //Toast.makeText(new MainActivity(), "You  Entered a Wrong Username or Password !", Toast .LENGTH_SHORT).show();
                }
            }
        });
    }
     private boolean validate(String username, String password){
        if((username.equals("Sujit")) && (password.equals("12345")))
            return true;
        else
            return false;
    }
}