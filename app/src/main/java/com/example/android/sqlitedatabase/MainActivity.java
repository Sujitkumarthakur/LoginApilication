package com.example.android.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1, et2;
Button insert,view;
TextClock txtclk1;
database g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find view id for all the buttons and text views...
        et1=(EditText)findViewById(R.id.edittext1);
        et2=(EditText)findViewById(R.id.edittext2);
        insert=(Button)findViewById(R.id.butt);
        view=(Button)findViewById(R.id.butt2);
        g= new database(this);
       // SQLiteDatabase db=g.getReadableDatabase();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et1.getText().toString();
                String password=et2.getText().toString();

                if(name.equals("") || password.equals("") )
                {
                    //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Enter all the fields correctly", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   boolean i=g.insert_data(name, password);
                   if(i==true)
                   {
                       Toast.makeText(MainActivity.this, "Successfully inserted!", Toast.LENGTH_SHORT).show();
                   }
                }
                et1.setText("");
                et2.setText("");
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor t=g.getinfo();
                if(t.getCount()==0)
                {
                    Toast.makeText(MainActivity.this, "No data Found !", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer= new StringBuffer();
                while(t.moveToNext())
                {
                    buffer.append("username"+t.getString(1)+"\n");
                    buffer.append("password"+t.getString(2)+"\n");

                }
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Data from SqliteDatabase !");
                builder.setMessage(buffer.toString());
                builder.show();
            }

        });
    }
}